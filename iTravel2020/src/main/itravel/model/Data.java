package itravel.model;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Data {
    private List<User> users;

    private List<Book> books;
    private ArrayList<Member> members;
    public Data(){
        users   = new ArrayList<>();

        books   = new ArrayList<>();
        members = new ArrayList<>();
    }

    // ------------------- User Management
    public List<User> getUserList(){
        return users;
    }

    public User getUser(String id){
        return users.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public int getUserIdx(String id){
        for (int i=0; i < users.size(); i++){
            if (users.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }

    public void addUser(String id, String userType, String fullName, String gender, String state, String city, String street,
                        String zipCode, Integer birthYear, String email, String password){
        users.add(new User(id, userType, fullName, gender, state, city, street, zipCode, birthYear, email, password));
    }

    public void updUser(String id, String userType, String fullName, String gender, String state, String city, String street,
                        String zipCode, Integer birthYear, String email, String password){
        int curIdx = getUserIdx(id);
        User curUser = getUser(id);

        curUser.setUserType(userType);
        curUser.setFullName(fullName);
        curUser.setGender(gender);
        curUser.setState(state);
        curUser.setCity(city);
        curUser.setStreet(street);
        curUser.setZipCode(zipCode);
        curUser.setBirthYear(birthYear);
//        curUser.setEmail(email); // Do not update email
        curUser.setPassword(password);
        // Update
        users.set(curIdx, curUser);
    }

    public void delUser(String id){
        int idx = getUserIdx(id);
        if (idx != -1)
            users.remove(idx);
    }

    public List<User> searchUser(String name){
/*
        return users.parallelStream()

                .filter(b -> b.getTitle().toLowerCase().contains(name.toLowerCase())
                        || b.getAuthor().toLowerCase().contains(name.toLowerCase())
                        || b.getIsbn().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
*/
        return null;
    }

    public User getUserByEmail(String email){
        // return users.parallelStream().filter(b -> b.getEmail().equals(email)).findAny().orElse(null);
        for (int i=0; i<users.size(); i++)
        {
            User item = users.get(i);
            if (item.getEmail().equals(email))
                return item;
        }
        // Not found
        return null;
    }

    public User login(String userName, String password){
        User item = getUserByEmail(userName);
        if (item != null){
            if (password.equals(item.getPassword())){
                return item;
            }
        }
        // Not found or login error
        return null;
    }

    // ------------------- Book Management
    public List<Book> getBookList(){
        return books;
    }

    public Book getBook(String id){
        return books.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public int getBookIdx(String id){
        for (int i=0; i < books.size(); i++){
            if (books.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }

    public void addBook(String id, String title, String author, String subject, String isbn){
        books.add(new Book(id, title, author, subject, isbn));
    }

    public void updBook(String id, String title, String author, String subject, String isbn){
        int curIdx = getBookIdx(id);
        Book curBook = getBook(id);

        curBook.setTitle(title);
        curBook.setAuthor(author);
        curBook.setSubject(subject);
        curBook.setIsbn(isbn);
        // Update
        books.set(curIdx, curBook);
    }

    public void delBook(String id){
        int idx = getBookIdx(id);
        if (idx != -1)
            books.remove(idx);
    }

    public List<Book> searchBook(String name){
        return books.parallelStream()
                .filter(b -> b.getTitle().toLowerCase().contains(name.toLowerCase())
                        || b.getAuthor().toLowerCase().contains(name.toLowerCase())
                        || b.getIsbn().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // ------------------- Member Management
    public List<Member> getMemberList(){
        return members;
    }

    public Member getMember(String id){
        return members.parallelStream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }

    public int getMemberIdx(String id){
/*
        return Integer.parseInt(members.parallelStream()

                .map(b -> b.getId())
                .filter(i -> i.equals(id)).findAny()
                .orElse("-1"));
 */
        for (int i=0; i < members.size(); i++){
            if (members.get(i).getId().equals(id))
                return i;
        }
        // not found
        return -1;
    }

    public void addMember(String id, String name, String address, String phone){
        members.add(new Member(id, name, address, phone));
    }

    public void updMember(String id, String name, String address, String phone){
        int curIdx = getMemberIdx(id);
        Member curMem = getMember(id);

        curMem.setName(name);
        curMem.setAddress(address);
        curMem.setPhone(phone);
        // Update
        members.set(curIdx, curMem);
    }

    public void delMember(String id){
        int idx = getMemberIdx(id);
        if (idx != -1)
            members.remove(idx);
    }

    public List<Member> searchMember(String name){
        return members.parallelStream()
                .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase())
                        || m.getAddress().toLowerCase().contains(name.toLowerCase())
                        || m.getPhone().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
