namespace Doppelganger;

public struct SendRequest
{
    public SendRequest(string email, string name, string subject, string message) : this()
    {
        Email = email;
        Name = name;
        Message = message;
        Subject = subject;
    }

    string Name { get; }
    string Email { get; }
    string Subject { get; }
    string Message { get; }
}

