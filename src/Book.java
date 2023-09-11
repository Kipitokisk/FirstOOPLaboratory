public class Book {
    String title;
    String author;
    int totalNrOfPages;
    int currentPage;

    public void nextPage(){
        if (currentPage + 1 <= totalNrOfPages && currentPage >= 0){
            currentPage += 1;
        } else {
            System.out.println("No more pages.");
        }
    }

    public void goToPage(int nr){
        if (nr >= 0 && nr <= totalNrOfPages){
            currentPage = nr;
        }
    }

    public void pageNumberDisplay(){
        System.out.println("Current page is " + currentPage);
    }

}
