package com.nicebao.Dao;



import com.nicebao.Bean.Pet;
import com.nicebao.util.Conn;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/5
**/
public class PetDAO {

    Pet pt;
    String[] strName2;
    String[] strName;
    String[] strPet;
    ArrayList<Pet> arrayList = new ArrayList<Pet>();

    // 查询宠物信息，优化条件查询逻辑，减少重复代码
    public List<Pet> searchPets(String petName, String ownerName) {
        List<Pet> pets = new ArrayList<>();
        String sql = petName.isEmpty()
                ? "SELECT * FROM pets WHERE owner_id IN (SELECT id FROM owners WHERE name LIKE ?)"
                : "SELECT * FROM pets WHERE name LIKE ?";
        try (Conn cn = new Conn()) {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.pr.setString(1, petName.isEmpty() ? ownerName + "%" : petName + "%");
            cn.rs = cn.pr.executeQuery();
            while (cn.rs.next()) {
                Pet pet = new Pet();
                pet.setName(cn.rs.getString("name"));
                pet.setOwnerName(ownerName);
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // 获取宠物信息
    public List<Pet> getPetDetails(String petName) {
        List<Pet> petDetails = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE name = ?";
        try (Conn cn = new Conn()) {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.pr.setString(1, petName);
            cn.rs = cn.pr.executeQuery();
            while (cn.rs.next()) {
                Pet pet = new Pet();
                pet.setId(cn.rs.getInt("id"));
                pet.setName(cn.rs.getString("name"));
                pet.setBirthDate(cn.rs.getString("birth_date"));
                pet.setType(getTypeById(cn.rs.getString("type_id")));
                pet.setOwnerName(getOwnerNameById(cn.rs.getString("owner_id")));
                petDetails.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petDetails;
    }

    // 通过 typeId 获取宠物类型
    private String getTypeById(String typeId) {
        String type = "";
        String sql = "SELECT name FROM types WHERE id = ?";
        try (Conn cn = new Conn()) {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.pr.setString(1, typeId);
            cn.rs = cn.pr.executeQuery();
            if (cn.rs.next()) {
                type = cn.rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    // 通过 ownerId 获取宠物主人姓名
    private String getOwnerNameById(String ownerId) {
        String name = "";
        String sql = "SELECT name FROM owners WHERE id = ?";
        try (Conn cn = new Conn()) {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.pr.setString(1, ownerId);
            cn.rs = cn.pr.executeQuery();
            if (cn.rs.next()) {
                name = cn.rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }





    public ArrayList<Pet> petMess(String petname){
        Conn cn = new Conn();
        String typeid,ownerid;
        String sql = "select * from pets where name = '"+petname+"'";
        try {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.rs = cn.pr.executeQuery();
            cn.rs.first();
            pt = new Pet();
            typeid = cn.rs.getString("type_id");
            ownerid = cn.rs.getString("owner_id");
            pt.setId(cn.rs.getInt("id"));
            pt.setName(cn.rs.getString("name"));
            pt.setBirthDate(cn.rs.getString("birth_date"));
            pt.setType(getType(typeid));
            pt.setOwnerName(getOwnerName(ownerid));
            arrayList.add(pt);
        }catch (Exception e){
            e.printStackTrace();
        }
        cn.close();
        return arrayList;
    }


    public String getOwnerName(String ownerId){
        Conn cn = new Conn();
        String name="";
        String sql = "select name from owners where id = '"+ownerId+"'";
        try {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.rs = cn.pr.executeQuery();
            while (cn.rs.next()){
                name = cn.rs.getString("name");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        cn.close();
        return name;
    }


    public String getType(String typeId){
        Conn cn = new Conn();
        String type="";
        String sql = "select name from types where id = '"+typeId+"'";
        try {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.rs = cn.pr.executeQuery();
            while (cn.rs.next()){
                type = cn.rs.getString("name");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        cn.close();
        return type;
    }


    public void petUpdate(Pet pet){

        Conn cn = new Conn();
        String sql = "update pets set name=?,birth_date=?," +
                "type_id=(select id from types where name = '"+pet.getType()+"')," +
                "owner_id=(select id from owners where name = '"+pet.getOwnerName()+
                "') where id = "+pet.getId();
        try {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.pr.setObject(1,pet.getName());
            cn.pr.setObject(2,pet.getBirthDate());
            cn.pr.executeUpdate();
            cn.pr.execute("commit ");
        }catch (Exception e){
            e.printStackTrace();
        }
        cn.close();
    }


    public ArrayList<Pet> getTypeSelect(){
        Conn cn = new Conn();
        ArrayList<Pet> ptTy = new ArrayList<Pet>();
        String sql = "select name from types";
        try {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.rs = cn.pr.executeQuery();
            while (cn.rs.next()){
                pt = new Pet();
                pt.setType(cn.rs.getString("name"));
                ptTy.add(pt);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        cn.close();
        return ptTy;
    }


    public void addPet(Pet pet) {
        String sql = "INSERT INTO pets (name, birth_date, type_id, owner_id) VALUES (?, ?, "
                + "(SELECT id FROM types WHERE name = ?), "
                + "(SELECT id FROM owners WHERE name = ?))";
        try (Conn cn = new Conn()) {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.pr.setString(1, pet.getName());
            cn.pr.setString(2, pet.getBirthDate());
            cn.pr.setString(3, pet.getType());
            cn.pr.setString(4, pet.getOwnerName());
            cn.pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public ArrayList<Pet> allPet(int page, int pageSize) {
        ArrayList<Pet> arrayList = new ArrayList<>();
        int[] id = getPetOwnerId();
        Conn cn = new Conn();
        String[] strName = new String[21];
        try {
            int offset = (page - 1) * pageSize;
            for (int j = 0; id[j] != 0; j++) {
                String sql = "SELECT * FROM owners WHERE id = ? LIMIT ? OFFSET ?";
                cn.pr = cn.cn.prepareStatement(sql);
                cn.pr.setInt(1, id[j]);
                cn.pr.setInt(2, pageSize);
                cn.pr.setInt(3, offset);
                cn.rs = cn.pr.executeQuery();
                while (cn.rs.next()) {
                    strName[j] = cn.rs.getString("name");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; strName[i] != null; i++) {
            Pet pt = new Pet();
            pt.setOwnerName(strName[i]);
            pt.setName(strPet[i]);
            arrayList.add(pt);
        }

        cn.close();
        return arrayList;
    }



    public int[] getPetOwnerId(){
        int i = 0;
        int[] id = new int[21];
        strPet = new String[21];
        Conn cn = new Conn();
        String sql = "select * from pets";
        try {
            cn.pr = cn.cn.prepareStatement(sql);
            cn.rs = cn.pr.executeQuery();
            while (cn.rs.next()) {
                id[i] = cn.rs.getInt("owner_id");
                strPet[i] = cn.rs.getString("name");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cn.close();
        return id;
    }


    public void delPet(String petName, String ownerName){
        System.out.println(petName+"pet");
        delConn(petName);
        Conn cn = new Conn();
        try {
            String sql = "delete from owners where name = '"+ownerName+"'";
            cn.pr = cn.cn.prepareStatement(sql);
            cn.pr.execute();
            cn.pr.execute("commit ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cn.close();
    }

    public void delConn(String petName){
        int petId = 0;
        Conn cn = new Conn();
        try {
            String sql = "select * from pets where name = '"+petName+"'";
            cn.pr = cn.cn.prepareStatement(sql);
            cn.rs = cn.pr.executeQuery();
            while (cn.rs.next()) {
                petId = cn.rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cn.close();
        delVisit(petId);
        delPet(petId);
    }

    public void delPet(int id){
        Conn cn = new Conn();
        try {
            String sql = "delete from pets where id = "+id;
            cn.pr = cn.cn.prepareStatement(sql);
            cn.pr.execute();
            cn.pr.execute("commit ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cn.close();
    }




    public void delVisit(int petId){
        Conn cn = new Conn();
        String sql = "delete from visits where pet_id = "+petId;
        try {
                cn.pr = cn.cn.prepareStatement(sql);
                cn.pr.execute();
                cn.pr.execute("commit ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cn.close();
    }

    public int getTotalPetCount() {
        int count = 0;
        Conn cn = new Conn();
        try {
            String sql = "SELECT COUNT(*) FROM pets";
            cn.pr = cn.cn.prepareStatement(sql);
            cn.rs = cn.pr.executeQuery();
            if (cn.rs.next()) {
                count = cn.rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cn.close();
        return count;
    }


}
