package k4;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ua.z0 f7051d = ua.i0.o(40010);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ua.z0 f7052e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f7054h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f7057c;

    static {
        Object[] objArr = {50000, 50001, 50002, 50003, 50004, 50005, 50006};
        ua.q.b(7, objArr);
        f7052e = ua.i0.i(7, objArr);
        int i = y1.a0.f14551a;
        f = Integer.toString(0, 36);
        f7053g = Integer.toString(1, 36);
        f7054h = Integer.toString(2, 36);
    }

    public k1(int i) {
        y1.d.a("commandCode shouldn't be COMMAND_CODE_CUSTOM", i != 0);
        this.f7055a = i;
        this.f7056b = "";
        this.f7057c = Bundle.EMPTY;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k1)) {
            return false;
        }
        k1 k1Var = (k1) obj;
        return this.f7055a == k1Var.f7055a && TextUtils.equals(this.f7056b, k1Var.f7056b);
    }

    public final int hashCode() {
        return Objects.hash(this.f7056b, Integer.valueOf(this.f7055a));
    }

    public k1(String str, Bundle bundle) {
        this.f7055a = 0;
        this.f7056b = str;
        bundle.getClass();
        this.f7057c = new Bundle(bundle);
    }
}
