package b2;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class y extends l {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f1733x;

    public y(int i) {
        super(i == 2000 ? 2001 : i);
        this.f1733x = 1;
    }

    public static y a(IOException iOException, int i) {
        String message = iOException.getMessage();
        int i10 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !android.support.v4.media.session.b.O(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i10 == 2007 ? new x(2007, iOException, "Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted") : new y(iOException, i10, i);
    }

    public y(int i, String str) {
        super(i == 2000 ? 2001 : i, str);
        this.f1733x = 1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public y(IOException iOException, int i, int i10) {
        if (i == 2000 && i10 == 1) {
            i = 2001;
        }
        super(iOException, i);
        this.f1733x = i10;
    }

    public y(int i, IOException iOException, String str) {
        super(str, iOException, i == 2000 ? 2001 : i);
        this.f1733x = 1;
    }
}
