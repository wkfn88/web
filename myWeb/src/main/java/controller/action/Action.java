package controller.action;

import com.oreilly.servlet.MultipartRequest;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface Action
{
  public abstract void execute(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException;

  public abstract void execute(MultipartRequest paramMultipartRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException;
}
