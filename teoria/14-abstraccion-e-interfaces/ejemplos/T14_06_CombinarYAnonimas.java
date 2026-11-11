/*
 * TEMA 14 · Abstracción e interfaces
 * Ejemplo 06: INTERFAZ + CLASE ABSTRACTA, Y CLASES ANÓNIMAS
 *
 * Cómo ejecutarlo:  java T14_06_CombinarYAnonimas.java
 */
public class T14_06_CombinarYAnonimas {

    // ------------------------------------------------------------
    // 1. La interfaz define el CONTRATO
    // ------------------------------------------------------------
    interface Notificador {
        boolean enviar(String destinatario, String mensaje);

        String getCanal();
    }

    // ------------------------------------------------------------
    // 2. La clase abstracta implementa la parte COMÚN del contrato
    // ------------------------------------------------------------
    abstract static class NotificadorBase implements Notificador {
        private int enviados = 0;

        // Plantilla común: valida, delega en la subclase y cuenta
        @Override
        public final boolean enviar(String destinatario, String mensaje) {
            boolean ok = esDestinoValido(destinatario) && !mensaje.isBlank();
            if (ok) {
                entregar(destinatario, mensaje);
                enviados++;
            } else {
                System.out.println("  ✘ [" + getCanal() + "] destino o mensaje no válido: " + destinatario);
            }
            return ok;
        }

        public int getEnviados() {
            return enviados;
        }

        // Lo que cambia en cada canal
        protected abstract boolean esDestinoValido(String destinatario);

        protected abstract void entregar(String destinatario, String mensaje);
    }

    // ------------------------------------------------------------
    // 3. Las clases concretas solo escriben lo específico
    // ------------------------------------------------------------
    static class Email extends NotificadorBase {
        @Override
        public String getCanal() {
            return "Email";
        }

        @Override
        protected boolean esDestinoValido(String destinatario) {
            return destinatario.contains("@");
        }

        @Override
        protected void entregar(String destinatario, String mensaje) {
            System.out.println("  📧 Para " + destinatario + ": " + mensaje);
        }
    }

    static class Sms extends NotificadorBase {
        @Override
        public String getCanal() {
            return "SMS";
        }

        @Override
        protected boolean esDestinoValido(String destinatario) {
            return destinatario.length() == 9 && destinatario.chars().allMatch(Character::isDigit);
        }

        @Override
        protected void entregar(String destinatario, String mensaje) {
            String corto = mensaje.length() > 20 ? mensaje.substring(0, 20) + "…" : mensaje;
            System.out.println("  📱 SMS a " + destinatario + ": " + corto);
        }
    }

    public static void main(String[] args) {

        Email email = new Email();
        Sms sms = new Sms();

        email.enviar("ana@correo.com", "Tu pedido ha salido del almacén");
        email.enviar("ana-correo.com", "Esto no llegará");
        sms.enviar("600123456", "Tu código de verificación es 4821");
        sms.enviar("12", "Número incorrecto");
        System.out.println("Enviados → email: " + email.getEnviados() + ", SMS: " + sms.getEnviados());
        System.out.println();

        // ------------------------------------------------------------
        // 4. Clase ANÓNIMA: implementar la interfaz "sobre la marcha", una sola vez
        // ------------------------------------------------------------
        Notificador consola = new Notificador() {
            @Override
            public boolean enviar(String destinatario, String mensaje) {
                System.out.println("  🖥 [" + destinatario + "] " + mensaje.toUpperCase());
                return true;
            }

            @Override
            public String getCanal() {
                return "Consola";
            }
        };

        // Todos son Notificador: se pueden tratar igual
        Notificador[] canales = {email, sms, consola};
        for (Notificador n : canales) {
            System.out.println("Canal " + n.getCanal() + ":");
            n.enviar(n == sms ? "611222333" : "equipo@empresa.com", "Reunión a las 10:00");
        }

        // En el tema 19 verás que, cuando la interfaz tiene UN solo método abstracto,
        // una lambda sustituye a la clase anónima en una línea.
    }
}
