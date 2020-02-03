package fmi.informatics.events;


public abstract class TestUnit extends PeopleSayHi {
    public static void main(String[] args) {
        String expectedResult = "Hello people";
        PeopleSayHi peopleSayHi = new PeopleSayHi();
        String result = peopleSayHi.pickPerson();

        getPeopleSayHiTest(expectedResult,result);
    }

    public static void getPeopleSayHiTest(String expectedResult, String result){
        if (stringComparison(expectedResult, result)) {
            System.out.println("Method pickPerson() from class PeopleSayHi returns what is expected");
        } else {
            System.err.println(
                    "Method pickPerson() from class PeopleSayHi returns: " +
                            result + ", but the expected result is: " +
                            expectedResult
            );
        }

    }

    public static boolean stringComparison(String expectedResult, String result) {
        return result.equals(expectedResult);
    }


}
