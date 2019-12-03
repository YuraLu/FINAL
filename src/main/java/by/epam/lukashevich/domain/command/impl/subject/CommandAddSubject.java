package by.epam.lukashevich.domain.command.impl.subject;

import by.epam.lukashevich.domain.command.Command;
import by.epam.lukashevich.domain.command.exception.CommandException;
import by.epam.lukashevich.domain.entity.Subject;
import by.epam.lukashevich.domain.service.ServiceProvider;
import by.epam.lukashevich.domain.service.SubjectService;
import by.epam.lukashevich.domain.service.exception.ServiceException;
import by.epam.lukashevich.domain.util.builder.impl.SubjectBuilderImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.lukashevich.domain.util.config.BeanFieldJsp.REDIRECT_COMMAND;
import static by.epam.lukashevich.domain.util.config.BeanFieldJsp.SUBJECT_NAME;
import static by.epam.lukashevich.domain.util.config.JSPActionCommand.VIEW_SUBJECT_TABLE_COMMAND;
import static by.epam.lukashevich.domain.util.config.JSPPages.SUBJECT_TABLE_PAGE;

public class CommandAddSubject implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, CommandException {

        final HttpSession session = request.getSession();
        final SubjectService subjectService = ServiceProvider.getInstance().getSubjectService();
        final String name = request.getParameter(SUBJECT_NAME);

        try {
            final Subject subject = new SubjectBuilderImpl()
                    .withName(name)
                    .build();

            subjectService.add(subject);

        } catch (ServiceException e) {
            throw new CommandException("Can't add subject in execute() CommandAddSubject", e);
        }
        session.setAttribute(REDIRECT_COMMAND, VIEW_SUBJECT_TABLE_COMMAND);
        return SUBJECT_TABLE_PAGE;
    }
}