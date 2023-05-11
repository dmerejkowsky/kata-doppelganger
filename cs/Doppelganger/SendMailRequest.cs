namespace Doppelganger;

public readonly struct SendMailRequest
{
    public SendMailRequest(string recipient, string subject, string body) : this()
    {
        Recipient = recipient;
        Subject = subject;
        Body = body;
    }

    public string Recipient { get; }
    public string Subject { get; }
    public string Body { get; }
}

