import org.junit.*;;

public class AMSTest1 {

	@Test
	public void test1() {
		
			savingAcc Acc = new savingAcc("12/09/2021","2178","Saif","H.no21","425");
			Acc.makeDeposit(25000);
			if(Acc.balance == 25000)
			{
				Assert.assertTrue(true);
			}
			Acc.makeWithdrawl(1200);
			
			if(Acc.balance == 23800)
			{
				Assert.assertTrue(true);
			}
	}

}
