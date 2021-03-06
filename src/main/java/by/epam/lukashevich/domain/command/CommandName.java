package by.epam.lukashevich.domain.command;

import by.epam.lukashevich.domain.command.exception.CommandException;

public enum CommandName {

    VIEW_INDEX("viewIndex"),
    VIEW_SIGN_IN("viewSignIn"),
    VIEW_SIGN_UP("viewSignUp"),
    VIEW_USER_CABINET("viewUserCabinet"),
    VIEW_USER_TABLE("viewUserTable"),
    CHANGE_USER_STATUS("changeUserStatus"),
    CHANGE_USER_BAN_STATUS("changeUserBanStatus"),
    SIGN_IN("signIn"),
    SIGN_UP("signUp"),
    SIGN_OUT("signOut"),
    EDIT_USER("editUser"),
    UPDATE_PASSWORD("updatePassword"),

    VIEW_TEST_TABLE("viewTestTable"),
    VIEW_TEST_WORK_PAGE("viewTestWorkPage"),
    VIEW_PASS_TEST_PAGE("viewPassTestPage"),
    VIEW_PASS_TEST_QUESTION_PAGE("viewPassTestQuestionPage"),
    VIEW_PASS_TEST_RESULT_PAGE("viewPassTestResultPage"),
    ADD_TEST("addTest"),
    DELETE_TEST("deleteTest"),
    ABORT_TEST("abortTest"),
    FINISH_TEST("finishTest"),
    GET_NEXT_TEST_QUESTION("getNextTestQuestion"),

    VIEW_SUBJECT_TABLE("viewSubjectTable"),
    ADD_SUBJECT("addSubject"),
    DELETE_SUBJECT("deleteSubject"),

    ADD_QUESTION("addQuestion"),
    DELETE_QUESTION("deleteQuestion"),
    VIEW_QUESTION_WORK_PAGE("viewQuestionWorkPage");

    private final String name;

    CommandName(String name) {
        this.name = name;
    }

    public static CommandName fromValue(String receivedCommandName) throws CommandException {
        for (CommandName commandName : CommandName.values()) {
            if (commandName.name.equals(receivedCommandName)) {
                return commandName;
            }
        }
        throw new CommandException("There is no such command");
    }

    public String getName() {
        return name;
    }
}