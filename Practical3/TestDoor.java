import java.util.Scanner;

class Door {
    protected Boolean isOpened = false;
    protected Scanner input = new Scanner(System.in);

    public void openDoor() {
        if (!isOpened) {
            System.out.println("Door opened.");
            isOpened = true;
        } else {
            System.out.println("Door already opened!");
        }
    }

    public void closeDoor() {
        if (isOpened) {
            System.out.println("Door closed.");
            isOpened = false;
        } else {
            System.out.println("Door already closed!");
        }
    }
}

class DoorWithLock extends Door {
    protected Boolean isLocked = false;


    public void openDoor() {
        if (isOpened) {
            System.out.println("Door already opened!");
        } else if (isLocked) {
            System.out.println("Door is locked and cannot be opened!");
        } else {
            System.out.println("Door opened.");
            isOpened = true;
        }
    }

    public void lockDoor() {
        if (isOpened) {
            System.out.println("Open door cannot be locked!");
        } else if (isLocked) {
            System.out.println("Door already locked!");
        } else {
            System.out.println("Door locked.");
            isLocked = true;
        }
    }

    public void unlockDoor() {
        if (!isLocked) {
            System.out.println("Door is not locked!");
        } else {
            System.out.println("Door unlocked.");
            isLocked = false;
        }
    }
}

class DoorWithCodeLock extends DoorWithLock {
    protected int code = 0;

    public void lockDoor() {
        if (isOpened) {
            System.out.println("Open door cannot be locked!");
        } else if (isLocked) {
            System.out.println("Door already locked!");
        } else {
            System.out.println("Set a code:");
            code = input.nextInt();
            System.out.println("Door locked.");
            isLocked = true;
        }
    }

    public void unlockDoor() {
        if (!isLocked) {
            System.out.println("Door is not locked!");
        } else {
            System.out.println("Input code to unlock:");
            if (code == input.nextInt()) {
                System.out.println("Door unlocked.");
                isLocked = false;
            }else{
                System.out.println("Invalid code!");
            }
        }
    }
}

public class TestDoor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DoorWithCodeLock D = new DoorWithCodeLock();
        System.out.println("Input a number:\n" +
                "1: Open door\n" +
                "2: Close door\n" +
                "3: Lock door\n" +
                "4: Unlock door\n" +
                "5: Exit");
        while (true) {
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    D.openDoor();
                    break;
                case 2:
                    D.closeDoor();
                    break;
                case 3:
                    D.lockDoor();
                    break;
                case 4:
                    D.unlockDoor();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
