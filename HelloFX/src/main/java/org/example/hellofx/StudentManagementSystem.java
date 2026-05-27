package org.example.hellofx;


import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.*;

public class StudentManagementSystem extends Application {
    //  DATA MODELS
    //Represents a student with an ID, name, email, and course year.
    static class Student {
        private final StringProperty studentId;
        private final StringProperty name;
        private final StringProperty email;
        private final StringProperty year;
        public Student(String studentId, String name, String email, String year) {
            this.studentId = new SimpleStringProperty(studentId);
            this.name      = new SimpleStringProperty(name);
            this.email     = new SimpleStringProperty(email);
            this.year      = new SimpleStringProperty(year);
        }

        public String getStudentId()             { return studentId.get(); }
        public void   setStudentId(String v)     { studentId.set(v); }
        public StringProperty studentIdProperty(){ return studentId; }

        public String getName()                  { return name.get(); }
        public void   setName(String v)          { name.set(v); }
        public StringProperty nameProperty()     { return name; }

        public String getEmail()                { return email.get(); }
        public void   setEmail(String v)        { email.set(v); }
        public StringProperty emailProperty()   { return email; }

        public String getYear()                 { return year.get(); }
        public void   setYear(String v)         { year.set(v); }
        public StringProperty yearProperty()    { return year; }

        @Override public String toString()       { return getName() + " (" + getStudentId() + ")"; }
    }

    /**
     * Represents a course with a code and title.
     */
    public static class Course {
        private final StringProperty code;
        private final StringProperty title;

        public Course(String code, String title) {
            this.code  = new SimpleStringProperty(code);
            this.title = new SimpleStringProperty(title);
        }

        public String getCode()                { return code.get(); }
        public void   setCode(String v)        { code.set(v); }
        public StringProperty codeProperty()   { return code; }

        public String getTitle()               { return title.get(); }
        public void   setTitle(String v)       { title.set(v); }
        public StringProperty titleProperty()  { return title; }

        @Override public String toString()     { return getCode() + " – " + getTitle(); }
    }

    /**
     * Represents an enrollment linking a student to a course, with a grade.
     */
    public static class Enrollment {
        private final ObjectProperty<Student> student;
        private final ObjectProperty<Course>  course;
        private final StringProperty          grade;

        public Enrollment(Student student, Course course) {
            this.student = new SimpleObjectProperty<>(student);
            this.course  = new SimpleObjectProperty<>(course);
            this.grade   = new SimpleStringProperty("N/A");
        }

        public Student getStudent()                 { return student.get(); }
        public StringProperty studentNameProperty() { return student.get().nameProperty(); }

        public Course getCourse()                   { return course.get(); }
        public StringProperty courseTitleProperty() { return course.get().titleProperty(); }

        public String getGrade()                    { return grade.get(); }
        public void   setGrade(String v)            { grade.set(v); }
        public StringProperty gradeProperty()       { return grade; }
    }

    // ─────────────────────────────────────────────────────────
    //  DATA STORE  (single shared instance)
    // ─────────────────────────────────────────────────────────

    /**
     * Central in-memory store for all application data.
     * All panels share the same DataStore instance so any change
     * is immediately visible across the whole application.
     */
    public static class DataStore {
        public final ObservableList<Student>    students    = FXCollections.observableArrayList();
        public final ObservableList<Course>     courses     = FXCollections.observableArrayList();
        public final ObservableList<Enrollment> enrollments = FXCollections.observableArrayList();

        /** Seed some demo data so the app is not empty on first launch. */
        public DataStore() {
            // Sample students
            students.addAll(
                    new Student("S001", "Alice Kamau",  "alice@uni.ac.ke", "Year 1"),
                    new Student("S002", "Brian Otieno", "brian@uni.ac.ke", "Year 2"),
                    new Student("S003", "Carol Mwangi", "carol@uni.ac.ke", "Year 3")
            );
            // Sample courses
            courses.addAll(
                    new Course("CS101", "Introduction to Computer Science"),
                    new Course("CS201", "Data Structures & Algorithms"),
                    new Course("CS301", "Software Engineering"),
                    new Course("CS401", "Database Systems")
            );
            // Sample enrollments
            Enrollment e1 = new Enrollment(students.get(0), courses.get(0));
            Enrollment e2 = new Enrollment(students.get(0), courses.get(1));
            Enrollment e3 = new Enrollment(students.get(1), courses.get(0));
            e1.setGrade("A");
            e2.setGrade("B+");
            enrollments.addAll(e1, e2, e3);
        }

        /** Returns true if the student is already enrolled in the course. */
        public boolean isEnrolled(Student s, Course c) {
            return enrollments.stream().anyMatch(
                    e -> e.getStudent() == s && e.getCourse() == c);
        }

        /** Returns all enrollments for a given student. */
        public List<Enrollment> enrollmentsFor(Student s) {
            List<Enrollment> result = new ArrayList<>();
            for (Enrollment e : enrollments)
                if (e.getStudent() == s) result.add(e);
            return result;
        }
    }

    // ─────────────────────────────────────────────────────────
    //  HELPER – styled components
    // ─────────────────────────────────────────────────────────

    static Button primaryButton(String text) {
        Button b = new Button(text);
        b.setStyle("-fx-background-color:#1565C0;-fx-text-fill:white;"
                + "-fx-font-weight:bold;-fx-padding:7 18;-fx-background-radius:6;");
        b.setOnMouseEntered(e -> b.setStyle(
                "-fx-background-color:#0D47A1;-fx-text-fill:white;"
                        + "-fx-font-weight:bold;-fx-padding:7 18;-fx-background-radius:6;"));
        b.setOnMouseExited(e -> b.setStyle(
                "-fx-background-color:#1565C0;-fx-text-fill:white;"
                        + "-fx-font-weight:bold;-fx-padding:7 18;-fx-background-radius:6;"));
        return b;
    }

    static Button dangerButton(String text) {
        Button b = new Button(text);
        b.setStyle("-fx-background-color:#C62828;-fx-text-fill:white;"
                + "-fx-font-weight:bold;-fx-padding:7 18;-fx-background-radius:6;");
        b.setOnMouseEntered(e -> b.setStyle(
                "-fx-background-color:#B71C1C;-fx-text-fill:white;"
                        + "-fx-font-weight:bold;-fx-padding:7 18;-fx-background-radius:6;"));
        b.setOnMouseExited(e -> b.setStyle(
                "-fx-background-color:#C62828;-fx-text-fill:white;"
                        + "-fx-font-weight:bold;-fx-padding:7 18;-fx-background-radius:6;"));
        return b;
    }

    static Button secondaryButton(String text) {
        Button b = new Button(text);
        b.setStyle("-fx-background-color:#455A64;-fx-text-fill:white;"
                + "-fx-font-weight:bold;-fx-padding:7 18;-fx-background-radius:6;");
        return b;
    }

    static void showError(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title); a.setHeaderText(null); a.setContentText(message);
        a.showAndWait();
    }

    static void showInfo(String title, String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title); a.setHeaderText(null); a.setContentText(message);
        a.showAndWait();
    }

    // ─────────────────────────────────────────────────────────
    //  PANEL 1 – STUDENTS
    // ─────────────────────────────────────────────────────────

    /**
     * StudentsPanel manages the student list.
     * Features: Add, Edit, Delete students via dialog forms.
     * The TableView is bound directly to the DataStore list so it
     * refreshes automatically when data changes.
     */
    public static class StudentsPanel extends BorderPane {

        private final DataStore store;
        private final TableView<Student> table = new TableView<>();

        public StudentsPanel(DataStore store) {
            this.store = store;
            setPadding(new Insets(20));
            setStyle("-fx-background-color:#F5F7FA;");

            Label title = new Label("Student Records");
            title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 20));
            title.setTextFill(Color.web("#1A237E"));

            Button addBtn    = primaryButton("+ Add Student");
            Button editBtn   = secondaryButton("Edit");
            Button deleteBtn = dangerButton("Delete");

            HBox toolbar = new HBox(10, addBtn, editBtn, deleteBtn);
            toolbar.setAlignment(Pos.CENTER_LEFT);

            VBox topArea = new VBox(10, title, toolbar);
            topArea.setPadding(new Insets(0, 0, 15, 0));
            setTop(topArea);

            // ── Table columns using LAMBDAS (fixes reflection issue in modules) ──
            TableColumn<Student, String> idCol    = new TableColumn<>("Student ID");
            TableColumn<Student, String> nameCol  = new TableColumn<>("Full Name");
            TableColumn<Student, String> emailCol = new TableColumn<>("Email");
            TableColumn<Student, String> yearCol  = new TableColumn<>("Year");

            idCol.setCellValueFactory(data    -> data.getValue().studentIdProperty());
            nameCol.setCellValueFactory(data  -> data.getValue().nameProperty());
            emailCol.setCellValueFactory(data -> data.getValue().emailProperty());
            yearCol.setCellValueFactory(data  -> data.getValue().yearProperty());

            idCol.setPrefWidth(100);
            nameCol.setPrefWidth(200);
            emailCol.setPrefWidth(230);
            yearCol.setPrefWidth(100);

            table.getColumns().addAll(idCol, nameCol, emailCol, yearCol);
            table.setItems(store.students);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            table.setStyle("-fx-background-color:white;-fx-border-color:#CFD8DC;"
                    + "-fx-border-radius:6;-fx-background-radius:6;");
            setCenter(table);

            // ── Event Handlers ──
            addBtn.setOnAction(e -> openStudentDialog(null));

            editBtn.setOnAction(e -> {
                Student selected = table.getSelectionModel().getSelectedItem();
                if (selected == null) { showError("No Selection", "Please select a student to edit."); return; }
                openStudentDialog(selected);
            });

            deleteBtn.setOnAction(e -> {
                Student selected = table.getSelectionModel().getSelectedItem();
                if (selected == null) { showError("No Selection", "Please select a student to delete."); return; }
                store.enrollments.removeIf(en -> en.getStudent() == selected);
                store.students.remove(selected);
                showInfo("Deleted", "Student removed successfully.");
            });
        }

        /**
         * Opens a dialog to add a new student (when existing == null)
         * or edit an existing one.
         */
        private void openStudentDialog(Student existing) {
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle(existing == null ? "Add Student" : "Edit Student");

            GridPane grid = new GridPane();
            grid.setHgap(12); grid.setVgap(12);
            grid.setPadding(new Insets(20));

            TextField idField    = new TextField(existing == null ? "" : existing.getStudentId());
            TextField nameField  = new TextField(existing == null ? "" : existing.getName());
            TextField emailField = new TextField(existing == null ? "" : existing.getEmail());
            ComboBox<String> yearBox = new ComboBox<>(
                    FXCollections.observableArrayList("Year 1","Year 2","Year 3","Year 4"));
            yearBox.setValue(existing == null ? "Year 1" : existing.getYear());

            if (existing != null) idField.setDisable(true);

            grid.addRow(0, new Label("Student ID:"), idField);
            grid.addRow(1, new Label("Full Name:"),  nameField);
            grid.addRow(2, new Label("Email:"),      emailField);
            grid.addRow(3, new Label("Year:"),       yearBox);

            Button saveBtn   = primaryButton(existing == null ? "Add" : "Save");
            Button cancelBtn = secondaryButton("Cancel");
            HBox   btnRow    = new HBox(10, saveBtn, cancelBtn);
            btnRow.setAlignment(Pos.CENTER_RIGHT);
            grid.add(btnRow, 0, 4, 2, 1);

            saveBtn.setOnAction(e -> {
                String id    = idField.getText().trim();
                String name  = nameField.getText().trim();
                String email = emailField.getText().trim();
                String year  = yearBox.getValue();

                if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
                    showError("Validation Error", "All fields are required."); return;
                }
                if (!email.contains("@")) {
                    showError("Validation Error", "Please enter a valid email address."); return;
                }
                if (existing == null) {
                    boolean dup = store.students.stream()
                            .anyMatch(s -> s.getStudentId().equalsIgnoreCase(id));
                    if (dup) { showError("Duplicate ID", "A student with ID '" + id + "' already exists."); return; }
                    store.students.add(new Student(id, name, email, year));
                    showInfo("Success", "Student added successfully.");
                } else {
                    existing.setName(name);
                    existing.setEmail(email);
                    existing.setYear(year);
                    table.refresh();
                    showInfo("Success", "Student updated successfully.");
                }
                dialog.close();
            });

            cancelBtn.setOnAction(e -> dialog.close());
            dialog.setScene(new Scene(grid, 380, 240));
            dialog.showAndWait();
        }
    }

    // ─────────────────────────────────────────────────────────
    //  PANEL 2 – COURSES
    // ─────────────────────────────────────────────────────────

    /**
     * CoursesPanel manages the course catalogue.
     * Features: Add and Delete courses.
     */
    public static class CoursesPanel extends BorderPane {

        private final DataStore store;
        private final TableView<Course> table = new TableView<>();

        public CoursesPanel(DataStore store) {
            this.store = store;
            setPadding(new Insets(20));
            setStyle("-fx-background-color:#F5F7FA;");

            Label title = new Label("Course Catalogue");
            title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 20));
            title.setTextFill(Color.web("#1A237E"));

            Button addBtn    = primaryButton("+ Add Course");
            Button deleteBtn = dangerButton("Delete");
            HBox toolbar     = new HBox(10, addBtn, deleteBtn);
            toolbar.setAlignment(Pos.CENTER_LEFT);

            VBox topArea = new VBox(10, title, toolbar);
            topArea.setPadding(new Insets(0, 0, 15, 0));
            setTop(topArea);

            // ── Columns using lambdas ──
            TableColumn<Course, String> codeCol  = new TableColumn<>("Course Code");
            TableColumn<Course, String> titleCol = new TableColumn<>("Course Title");

            codeCol.setCellValueFactory(data  -> data.getValue().codeProperty());
            titleCol.setCellValueFactory(data -> data.getValue().titleProperty());

            codeCol.setPrefWidth(130);
            titleCol.setPrefWidth(370);

            table.getColumns().addAll(codeCol, titleCol);
            table.setItems(store.courses);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            table.setStyle("-fx-background-color:white;-fx-border-color:#CFD8DC;"
                    + "-fx-border-radius:6;-fx-background-radius:6;");
            setCenter(table);

            addBtn.setOnAction(e -> openCourseDialog());

            deleteBtn.setOnAction(e -> {
                Course selected = table.getSelectionModel().getSelectedItem();
                if (selected == null) { showError("No Selection", "Please select a course to delete."); return; }
                store.enrollments.removeIf(en -> en.getCourse() == selected);
                store.courses.remove(selected);
                showInfo("Deleted", "Course removed successfully.");
            });
        }

        private void openCourseDialog() {
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Add Course");

            GridPane grid = new GridPane();
            grid.setHgap(12); grid.setVgap(12);
            grid.setPadding(new Insets(20));

            TextField codeField  = new TextField();
            TextField titleField = new TextField();
            codeField.setPromptText("e.g. CS101");
            titleField.setPromptText("e.g. Introduction to Computing");

            grid.addRow(0, new Label("Course Code:"),  codeField);
            grid.addRow(1, new Label("Course Title:"), titleField);

            Button saveBtn   = primaryButton("Add");
            Button cancelBtn = secondaryButton("Cancel");
            HBox   btnRow    = new HBox(10, saveBtn, cancelBtn);
            btnRow.setAlignment(Pos.CENTER_RIGHT);
            grid.add(btnRow, 0, 2, 2, 1);

            saveBtn.setOnAction(e -> {
                String code  = codeField.getText().trim().toUpperCase();
                String title = titleField.getText().trim();
                if (code.isEmpty() || title.isEmpty()) { showError("Validation Error", "Both fields are required."); return; }
                boolean dup = store.courses.stream().anyMatch(c -> c.getCode().equalsIgnoreCase(code));
                if (dup) { showError("Duplicate", "A course with code '" + code + "' already exists."); return; }
                store.courses.add(new Course(code, title));
                showInfo("Success", "Course added successfully.");
                dialog.close();
            });

            cancelBtn.setOnAction(e -> dialog.close());
            dialog.setScene(new Scene(grid, 400, 180));
            dialog.showAndWait();
        }
    }

    // ─────────────────────────────────────────────────────────
    //  PANEL 3 – ENROLLMENT
    // ─────────────────────────────────────────────────────────

    /**
     * EnrollmentPanel handles enrolling students in courses.
     * Selecting a course populates eligible students (not yet enrolled).
     * A table below shows all current enrollments.
     */
    public static class EnrollmentPanel extends BorderPane {

        private final DataStore store;

        public EnrollmentPanel(DataStore store) {
            this.store = store;
            setPadding(new Insets(20));
            setStyle("-fx-background-color:#F5F7FA;");

            Label title = new Label("Course Enrollment");
            title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 20));
            title.setTextFill(Color.web("#1A237E"));

            ComboBox<Course>  courseBox  = new ComboBox<>(store.courses);
            ComboBox<Student> studentBox = new ComboBox<>();
            Button            enrollBtn  = primaryButton("Enroll Student");

            courseBox.setPromptText("Select a course...");
            studentBox.setPromptText("Select a student...");
            courseBox.setPrefWidth(280);
            studentBox.setPrefWidth(280);

            // Populate eligible students when a course is selected
            courseBox.setOnAction(e -> {
                Course selected = courseBox.getValue();
                if (selected == null) return;
                ObservableList<Student> eligible = FXCollections.observableArrayList();
                for (Student s : store.students)
                    if (!store.isEnrolled(s, selected)) eligible.add(s);
                studentBox.setItems(eligible);
                studentBox.setValue(null);
                studentBox.setPromptText(eligible.isEmpty() ? "All students enrolled" : "Select a student...");
            });

            GridPane form = new GridPane();
            form.setHgap(12); form.setVgap(12);
            form.setPadding(new Insets(15, 0, 15, 0));
            form.addRow(0, new Label("Course:"),  courseBox);
            form.addRow(1, new Label("Student:"), studentBox);
            form.add(enrollBtn, 1, 2);

            // ── Enrollments table ──
            Label tableTitle = new Label("Current Enrollments");
            tableTitle.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 15));
            tableTitle.setTextFill(Color.web("#37474F"));

            TableView<Enrollment> table = new TableView<>(store.enrollments);

            // ── Columns using lambdas ──
            TableColumn<Enrollment, String> snCol = new TableColumn<>("Student");
            TableColumn<Enrollment, String> cnCol = new TableColumn<>("Course");
            TableColumn<Enrollment, String> grCol = new TableColumn<>("Grade");

            snCol.setCellValueFactory(data -> data.getValue().studentNameProperty());
            cnCol.setCellValueFactory(data -> data.getValue().courseTitleProperty());
            grCol.setCellValueFactory(data -> data.getValue().gradeProperty());

            snCol.setPrefWidth(200);
            cnCol.setPrefWidth(280);
            grCol.setPrefWidth(80);
            table.getColumns().addAll(snCol, cnCol, grCol);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            table.setStyle("-fx-background-color:white;-fx-border-color:#CFD8DC;-fx-border-radius:6;");

            Button removeBtn = dangerButton("Remove Enrollment");
            removeBtn.setOnAction(e -> {
                Enrollment sel = table.getSelectionModel().getSelectedItem();
                if (sel == null) { showError("No Selection", "Select an enrollment to remove."); return; }
                store.enrollments.remove(sel);
                courseBox.fireEvent(new javafx.event.ActionEvent());
            });

            VBox center = new VBox(12, title, form, new Separator(), tableTitle, table, removeBtn);
            setCenter(center);

            enrollBtn.setOnAction(e -> {
                Course  c = courseBox.getValue();
                Student s = studentBox.getValue();
                if (c == null) { showError("Validation Error", "Please select a course."); return; }
                if (s == null) { showError("Validation Error", "Please select a student."); return; }
                if (store.isEnrolled(s, c)) {
                    showError("Already Enrolled", s.getName() + " is already enrolled in " + c.getTitle() + "."); return;
                }
                store.enrollments.add(new Enrollment(s, c));
                showInfo("Success", s.getName() + " enrolled in " + c.getTitle() + ".");
                courseBox.fireEvent(new javafx.event.ActionEvent());
            });
        }
    }

    // ─────────────────────────────────────────────────────────
    //  PANEL 4 – GRADES
    // ─────────────────────────────────────────────────────────

    /**
     * GradesPanel handles assigning grades to enrolled students.
     * Selecting a student shows only the courses they are enrolled in.
     */
    public static class GradesPanel extends BorderPane {

        private final DataStore store;
        private final TableView<Enrollment> table = new TableView<>();

        public GradesPanel(DataStore store) {
            this.store = store;
            setPadding(new Insets(20));
            setStyle("-fx-background-color:#F5F7FA;");

            Label title = new Label("Grade Management");
            title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 20));
            title.setTextFill(Color.web("#1A237E"));

            ComboBox<Student>    studentBox = new ComboBox<>(store.students);
            ComboBox<Enrollment> enrollBox  = new ComboBox<>();
            ComboBox<String>     gradeBox   = new ComboBox<>(
                    FXCollections.observableArrayList(
                            "A","A-","B+","B","B-","C+","C","C-","D+","D","F","N/A"));
            Button assignBtn = primaryButton("Assign Grade");

            studentBox.setPromptText("Select student...");
            enrollBox.setPromptText("Select course...");
            gradeBox.setValue("N/A");
            studentBox.setPrefWidth(280);
            enrollBox.setPrefWidth(280);
            gradeBox.setPrefWidth(100);

            // When student changes, show their enrolled courses
            studentBox.setOnAction(e -> {
                Student s = studentBox.getValue();
                if (s == null) return;
                List<Enrollment> es = store.enrollmentsFor(s);
                enrollBox.setItems(FXCollections.observableArrayList(es));
                enrollBox.setValue(null);
                table.setItems(FXCollections.observableArrayList(es));
                enrollBox.setPromptText(es.isEmpty() ? "Not enrolled in any course" : "Select course...");
            });

            // Pre-fill current grade when enrollment is selected
            enrollBox.setOnAction(e -> {
                Enrollment en = enrollBox.getValue();
                if (en != null) gradeBox.setValue(en.getGrade());
            });

            GridPane form = new GridPane();
            form.setHgap(12); form.setVgap(12);
            form.setPadding(new Insets(15, 0, 15, 0));
            form.addRow(0, new Label("Student:"),   studentBox);
            form.addRow(1, new Label("Course:"),    enrollBox);
            form.addRow(2, new Label("New Grade:"), gradeBox);
            form.add(assignBtn, 1, 3);

            Label tableTitle = new Label("Grades Overview");
            tableTitle.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 15));
            tableTitle.setTextFill(Color.web("#37474F"));

            // ── Columns using lambdas ──
            TableColumn<Enrollment, String> snCol = new TableColumn<>("Student");
            TableColumn<Enrollment, String> cnCol = new TableColumn<>("Course");
            TableColumn<Enrollment, String> grCol = new TableColumn<>("Grade");

            snCol.setCellValueFactory(data -> data.getValue().studentNameProperty());
            cnCol.setCellValueFactory(data -> data.getValue().courseTitleProperty());
            grCol.setCellValueFactory(data -> data.getValue().gradeProperty());

            snCol.setPrefWidth(200);
            cnCol.setPrefWidth(280);
            grCol.setPrefWidth(80);
            table.getColumns().addAll(snCol, cnCol, grCol);
            table.setItems(store.enrollments); // show all by default
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            table.setStyle("-fx-background-color:white;-fx-border-color:#CFD8DC;-fx-border-radius:6;");

            VBox center = new VBox(12, title, form, new Separator(), tableTitle, table);
            setCenter(center);

            assignBtn.setOnAction(e -> {
                Student    s  = studentBox.getValue();
                Enrollment en = enrollBox.getValue();
                String     g  = gradeBox.getValue();
                if (s == null)  { showError("Validation Error", "Please select a student."); return; }
                if (en == null) { showError("Validation Error", "Please select a course."); return; }
                if (g == null)  { showError("Validation Error", "Please select a grade."); return; }
                en.setGrade(g);
                table.refresh();
                showInfo("Success", "Grade " + g + " assigned to " + s.getName()
                        + " for " + en.getCourse().getTitle() + ".");
            });
        }
    }

    // ─────────────────────────────────────────────────────────
    //  MAIN APPLICATION
    // ─────────────────────────────────────────────────────────

    @Override
    public void start(Stage primaryStage) {
        DataStore store = new DataStore();

        Label header = new Label("  Student Management System");
        header.setFont(Font.font("Segoe UI", FontWeight.BOLD, 22));
        header.setTextFill(Color.WHITE);
        header.setPadding(new Insets(16, 20, 16, 20));

        HBox headerBar = new HBox(header);
        headerBar.setStyle("-fx-background-color:#1A237E;");
        headerBar.setAlignment(Pos.CENTER_LEFT);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setStyle("-fx-tab-min-width:130;-fx-font-size:13;");

        Tab studentsTab = new Tab("Students",   new StudentsPanel(store));
        Tab coursesTab  = new Tab("Courses",    new CoursesPanel(store));
        Tab enrollTab   = new Tab("Enrollment", new EnrollmentPanel(store));
        Tab gradesTab   = new Tab("Grades",     new GradesPanel(store));

        tabPane.getTabs().addAll(studentsTab, coursesTab, enrollTab, gradesTab);

        BorderPane root = new BorderPane();
        root.setTop(headerBar);
        root.setCenter(tabPane);

        Scene scene = new Scene(root, 780, 600);
        primaryStage.setTitle("Student Management System");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(500);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}