package h2;

import android.media.metrics.LogSessionId;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pc.c f5537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5538c;

    static {
        new l("");
    }

    public l(String str) {
        pc.c cVar;
        this.f5536a = str;
        if (Build.VERSION.SDK_INT >= 31) {
            cVar = new pc.c();
            cVar.f10180v = LogSessionId.LOG_SESSION_ID_NONE;
        } else {
            cVar = null;
        }
        this.f5537b = cVar;
        this.f5538c = new Object();
    }

    public final synchronized LogSessionId a() {
        pc.c cVar;
        cVar = this.f5537b;
        cVar.getClass();
        return (LogSessionId) cVar.f10180v;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Objects.equals(this.f5536a, lVar.f5536a) && Objects.equals(this.f5537b, lVar.f5537b) && Objects.equals(this.f5538c, lVar.f5538c);
    }

    public final int hashCode() {
        return Objects.hash(this.f5536a, this.f5537b, this.f5538c);
    }
}
