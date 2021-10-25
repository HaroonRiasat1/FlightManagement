package airlineManagement;

public class TestDataa{
	public void ageValidation(int age) throws Exceptions
	{
		if(age<14)
		{
			throw new Exceptions("You must be over 14 to reserve seat");
		}
	}
	public void genderValidation(String gender) throws Exceptions
	{
		if(!(gender.equals("Male")||gender.equals("Female")))
		{
			throw new Exceptions("Please Specify Gender in correct Format, First letter Capital and Rest Small");
		}
	}
	public void NullException(String a,String B) throws Exceptions
	{
		if(a.equals(null)||a.equals(""))
		{
			throw new Exceptions("Cannot Insert Null:"+B);
		}
	}
	public void yesno(String a) throws Exceptions
	{
		if(!(a.equals("y")||a.equals("Y")||a.equals("N")||a.equals("n")))
		{
			throw new Exceptions("Enter Y or y or N or n");
		}
	}
	public void EB(String a) throws Exceptions
	{
		if(!(a.equals("e")||a.equals("E")||a.equals("b")||a.equals("B")))
		{
			throw new Exceptions("Enter Y or y or N or n");
		}
	}
}
