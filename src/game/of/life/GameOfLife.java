/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.of.life;

/**
 *
 * @author 37067
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        char [][] field = new char [10][10];
//        for (int i = 0; i < field.length; i++) {
//            for (int j = 0; j < field[i].length; j++) {
//                if (Math.random() < 0.2) {
//                    field[i][j] = 'X';
//                } else {
//                    field[i][j] = '.';
//                }
//            }
//        }
        char[][] field = {
            {'.', 'X', '.', 'X'},
            {'.', '.', 'X', '.'},
            {'.', 'X', 'X', '.'},
            {'.', '.', '.', '.'},
            
        };
        // prints field
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println("------------------------");
        
        for (int c = 0; c < 50; c++) {
            char[][] newField = new char[field.length][field[0].length];
            // across all lines
            for (int i = 0; i < newField.length; i++) {
                // across all columns
                for (int j = 0; j < newField[i].length; j++) {
                    int neighbors = 0;
                    // check 3 positions above myself
                    if (i > 0) {
                        neighbors += (j > 0 && field[i - 1][j - 1] == 'X') ? 1 : 0;
                          // the same as
//                        if (j > 0) {
//                            if (field[i - 1][j - 1] == 'X') {
//                                neighbors++;
//                            }  
//                        }
                        neighbors += (field[i - 1][j] == 'X') ? 1 : 0;
                        // the same as
//                        if (field[i - 1][j] == 'X') {
//                            neighbors++;
//                        }
                        neighbors += (j < field[i].length - 1 && field[i - 1][j + 1] == 'X') ? 1 : 0;
                        // the same as
//                        if (j < field[i].length - 1) {
//                            if (field[i - 1][j + 1] == 'X') {
//                                neighbors++;
//                            }
//                        }
                    }
                    neighbors += (j > 0 && field[i][j - 1] == 'X') ? 1 : 0;
                    neighbors += (j < field[i].length - 1 && field[i][j + 1] == 'X') ? 1 : 0;
                    if (i < field.length - 1) {
                        neighbors += (j > 0 && field[i + 1][j - 1] == 'X') ? 1 : 0;
                        neighbors += (field[i + 1][j] == 'X') ? 1 : 0;
                        neighbors += (j < field[i].length - 1 && field[i + 1][j + 1] == 'X') ? 1 : 0;
                    }
                    if (field[i][j] == 'X') {
                        if (neighbors == 2 || neighbors == 3) {
                            newField[i][j] = 'X';
                        } else {
                            newField[i][j] = '.';
                        }
                    } else {
                        if (neighbors == 3) {
                            newField[i][j] = 'X';    
                        } else {
                            newField[i][j] = '.';
                        } 
                    }
                }
            }
            field = newField;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
            System.out.println(c + "------------------------");
        }
        
        
        
    }
    
}
