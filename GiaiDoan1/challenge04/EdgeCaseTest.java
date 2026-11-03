package GiaiDoan1.challenge04;

public class EdgeCaseTest {
    public static void main(String[] args) {
        System.out.println("=== KIEM THU GOC KHUAT & BIEN CUC HAN ===");
        
        // Edge 1: Credit Account sat nut han muc
        CreditAccount credit = new CreditAccount("Test User", "CRE-EDGE", 0.0, new Transaction[0], 1_040_000);
        boolean canWithdrawExact = credit.canWithdraw(1_000_000);
        System.out.println("CreditAccount: canWithdraw(1.000.000) voi han muc 1.040.000 -> " 
            + canWithdrawExact + " (Ky vong: true)");

        // Edge 2: Chuyen so tien = 0
        CheckingAccount checking = new CheckingAccount("User", "CHK-EDGE", 500_000, new Transaction[0]);
        CheckingAccount receiver = new CheckingAccount("Recv", "CHK-RECV", 0, new Transaction[0]);
        TransferService service = new TransferService();
        boolean transferZero = service.transfer(checking, receiver, 0);
        System.out.println("Chuyen 0 VND: " + transferZero + " (Ket qua: Cho phep va tu dong tru 1.000 VND phi!)");
        System.out.println("So du sau chuyen 0 VND: " + (long)checking.getBalance() + " VND");

        // Edge 3: Chuyen so tien am
        boolean transferNeg = service.transfer(checking, receiver, -100_000);
        System.out.println("Chuyen -100k VND: " + transferNeg + " (Ky vong: false) -> " + (!transferNeg ? "PASS" : "FAIL"));

        // Edge 4: Chuyen cho chinh minh
        boolean selfTransfer = service.transfer(checking, checking, 100_000);
        System.out.println("Chuyen cho chinh minh: " + selfTransfer + " | So du sau tu chuyen: " + (long)checking.getBalance() + " VND (Bi mat 1k phi)");
    }
}

