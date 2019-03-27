/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package bean;
package utils;
/**
 *
 * @author joshep
 */
 
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
 

public class ValidaCPF extends InputVerifier {
 
    /** (non-Javadoc)
     * @see javax.swing.InputVerifier#verify(javax.swing.JComponent)
     */
    @Override
    public boolean verify(JComponent component) {
        return verificaCampo(component);
    }
     
    /**
     * O método verificaCampo faz a efetiva verificação do CPF.
     * 
     * @param component o componente do tipo JTextField.
     * @return true se o CPF é válido, false caso contrário.
     */
    protected boolean verificaCampo(JComponent component) {
        boolean eValido = false; // Assume que o CPF é inválido
        String cpf = null;
        if (component instanceof JTextField) {
            JTextField tmp = (JTextField) component;
            cpf = tmp.getText();
        }
        else {
            return eValido;
        }
                // Os caracteres do CPF
        char[] caracteres = cpf.toCharArray();
                // Transformados em dígitos
        int[] digitos = new int[caracteres.length];
                // Variáveis temporárias
        int somaNove = 0, somaDez = 0;
                // Os dígitos de verificação do CPF
        int digitoDez = 0, digitoOnze = 0;
         
        if (caracteres.length != 11) {
            return eValido; // O CPF deve ter exatamente 11 dígitos.
        }
         
        for (int count = 0; count < caracteres.length; count++) {
            if (!Character.isDigit(caracteres[count])) {
                return eValido; // Se não for um dígito não é um CPF válido.
            }
        }
         
        // Transforma os caracteres em dígitos numéricos
        for (int count = 0; count < caracteres.length; count++) {
            digitos[count] = Character.getNumericValue(caracteres[count]);
            int valor = 0;
            // Soma os nove primeiros dígitos multiplicados 
                        // por um valor determinado.
            if (count < 9) {
                valor = digitos[count] * (11 - (count + 1));
                somaNove += valor;
            }
        }
         
        // Usa a soma para calcular o primeiro dígito verificador.
        digitoDez = 11 - (somaNove % 11);
        if (digitoDez > 9) {
            digitoDez = 0;
        }
         
        // Se o décimo dígito calculado for diferente do décimo dígito passado
        // o CPF não é válido.
        if (digitoDez != digitos[9]) {
            return eValido;
        }
         
        // Soma os 10 primeiros dígitos multiplicados por um valor 
                // determinado.
        for (int count = 0; count < digitos.length; count++) {
            int valor = 0;
            if (count < 10) {
                valor = digitos[count] * (12 - (count + 1));
                somaDez += valor;
            }
        }
         
        // Usa a soma para calcular o segundo dígito verificador.
        digitoOnze = 11 - (somaDez % 11);
        if (digitoOnze > 9) {
            digitoOnze = 0;
        }
         
        // Se o décimo primeiro dígito for diferente do dígito passado, 
        // o CPF não é válido.
        if (digitoOnze != digitos[10]) {
            return eValido;
        }
         
        // Se passou por todos os testes o CPF é válido
        eValido = true;
         
        return eValido;
    }
}

