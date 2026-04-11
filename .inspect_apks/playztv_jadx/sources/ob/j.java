package ob;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import k8.a0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f9501b = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f9502c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static j f9503d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f9504a;

    public j(a0 a0Var) {
        this.f9504a = a0Var;
    }

    public final boolean a(pb.a aVar) {
        if (TextUtils.isEmpty(aVar.f10302c)) {
            return true;
        }
        long j5 = aVar.f + aVar.f10304e;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f9504a.getClass();
        return j5 < timeUnit.toSeconds(System.currentTimeMillis()) + f9501b;
    }
}
