public class Main {

    public static void main(String[] args) {
        printMagnificentScene();
        praiseNature();
    }

    public static void printMagnificentScene() {
        String[] scene = {
                "                             *           ",
                "                        *       *        ",
                "                     *             *     ",
                "                   *                  *  ",
                "              *                            ",
                "         *             *             *    ",
                "    *                    *              * ",
                "        *         MOUNTAINS       *      ",
                "            *                       *    ",
                "  *          *                *         * ",
                "                 *     *                 ",
                "                      *                  ",
                "                                      *  ",
                "  *                                    *  ",
                "           *                           * ",
                "                *                  *     ",
                "                     *             *     ",
                "                        *       *        ",
                "                             *           "
        };

        for (String line : scene) {
            System.out.println(line);
        }
    }

    public static void praiseNature() {
        System.out.println("啊，这山河壮丽的景色，真是大自然的杰作！");
        System.out.println("仿佛美丽的画卷展现在我眼前。");
    }
}
