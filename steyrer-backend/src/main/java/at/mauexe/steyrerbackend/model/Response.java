package at.mauexe.steyrerbackend.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Response {
    public Response(boolean ok)
    {
        this.ok = ok;
    }
    public boolean ok;
    public String message;
}
