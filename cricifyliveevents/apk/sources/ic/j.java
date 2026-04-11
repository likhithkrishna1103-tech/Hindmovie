package ic;

import android.text.TextUtils;
import f9.c0;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f6435b = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f6436c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static j f6437d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f6438a;

    public j(c0 c0Var) {
        this.f6438a = c0Var;
    }

    public final boolean a(jc.b bVar) {
        if (TextUtils.isEmpty(bVar.f6738c)) {
            return true;
        }
        long j4 = bVar.f + bVar.f6740e;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f6438a.getClass();
        return j4 < timeUnit.toSeconds(System.currentTimeMillis()) + f6435b;
    }
}
