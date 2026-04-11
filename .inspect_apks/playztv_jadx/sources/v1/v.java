package v1;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class v extends j {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f13176w;

    public v(int i) {
        super(i == 2000 ? 2001 : i);
        this.f13176w = 1;
    }

    public static v a(int i, IOException iOException) {
        String message = iOException.getMessage();
        int i10 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !com.bumptech.glide.d.X(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i10 == 2007 ? new u(2007, iOException, "Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted") : new v(i10, i, iOException);
    }

    public v(String str, int i) {
        super(str, i == 2000 ? 2001 : i);
        this.f13176w = 1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public v(int i, int i10, IOException iOException) {
        if (i == 2000 && i10 == 1) {
            i = 2001;
        }
        super(iOException, i);
        this.f13176w = i10;
    }

    public v(int i, IOException iOException, String str) {
        super(str, iOException, i == 2000 ? 2001 : i);
        this.f13176w = 1;
    }
}
