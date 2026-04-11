package b2;

import android.media.metrics.LogSessionId;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u5.c f1788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1789c;

    static {
        new o("");
    }

    public o(String str) {
        u5.c cVar;
        this.f1787a = str;
        if (Build.VERSION.SDK_INT >= 31) {
            cVar = new u5.c(4, false);
            cVar.f12782v = LogSessionId.LOG_SESSION_ID_NONE;
        } else {
            cVar = null;
        }
        this.f1788b = cVar;
        this.f1789c = new Object();
    }

    public final synchronized LogSessionId a() {
        u5.c cVar;
        cVar = this.f1788b;
        cVar.getClass();
        return (LogSessionId) cVar.f12782v;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return Objects.equals(this.f1787a, oVar.f1787a) && Objects.equals(this.f1788b, oVar.f1788b) && Objects.equals(this.f1789c, oVar.f1789c);
    }

    public final int hashCode() {
        return Objects.hash(this.f1787a, this.f1788b, this.f1789c);
    }
}
