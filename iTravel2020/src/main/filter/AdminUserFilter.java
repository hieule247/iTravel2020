package filter;

/**
 * @author Hailian
 * @Poject name iTravel2020_2
 * @creat2020-11-11 3:41 PM
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class AdminUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);//如果不加这句，整个网站都会不显示

        //HttpServletRequest req = (HttpServletRequest) servletRequest;
        // HttpServletResponse resp = (HttpServletResponse) servletResponse;

    }
}
