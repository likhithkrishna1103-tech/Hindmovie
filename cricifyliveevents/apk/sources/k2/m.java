package k2;

import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import ua.i0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v1.p f6872v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i0 f6873w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f6874x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f6875y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final j f6876z;

    public m(v1.p pVar, List list, s sVar, List list2) {
        y1.d.b(!list.isEmpty());
        this.f6872v = pVar;
        this.f6873w = i0.k(list);
        this.f6875y = list2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list2);
        this.f6876z = sVar.a(this);
        long j4 = sVar.f6891c;
        long j7 = sVar.f6890b;
        int i = a0.f14551a;
        this.f6874x = a0.W(j4, 1000000L, j7, RoundingMode.DOWN);
    }

    public abstract String a();

    public abstract j2.i d();

    public abstract j e();
}
