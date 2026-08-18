class GradeEvalutionSystem{
	public static void main(String args[]){
	int Maths = 80;
	int Science = 85 ;
	int History = 90 ;
	
	int Average = (Maths + Science + History) / 3;
	System.out.println("Average marks = " + Average);
	
	if (Average>=90){
		System.out.println("Grade A");
	}else if (Average>=70&&Average<=89){
		System.out.println("Grade B");
		}else if (Average>=50&&Average<=69){
			System.out.println("Grade B");
			}else if (Average>=30&&Average<=49){
				System.out.println("Grade C");
				}else {
					System.out.println("fail");
		}
	}
}