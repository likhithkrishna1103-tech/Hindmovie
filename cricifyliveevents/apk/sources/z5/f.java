package z5;

import androidx.media3.decoder.DecoderInputBuffer;
import kf.m;
import kf.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements k {
    public final /* synthetic */ i A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f15212v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ String f15213w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ String f15214x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ String f15215y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ p f15216z;

    public /* synthetic */ f(String str, String str2, String str3, p pVar, i iVar, int i) {
        this.f15212v = i;
        this.f15213w = str;
        this.f15214x = str2;
        this.f15215y = str3;
        this.f15216z = pVar;
        this.A = iVar;
    }

    @Override // z5.k
    public final void f(String str, boolean z10) {
        switch (this.f15212v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e6.b bVar = new e6.b();
                bVar.a("source", this.f15213w);
                bVar.a("type", this.f15214x);
                bVar.a("data", str);
                m mVar = new m(bVar.f3812a, bVar.f3813b);
                String str2 = this.f15215y;
                android.support.v4.media.session.b.J(null, str2, true, mVar, this.f15216z, new androidx.fragment.app.e(25, str2, this.A));
                break;
            default:
                e6.b bVar2 = new e6.b();
                bVar2.a("source", this.f15213w);
                bVar2.a("type", this.f15214x);
                bVar2.a("status", str);
                android.support.v4.media.session.b.J(null, this.f15215y, true, new m(bVar2.f3812a, bVar2.f3813b), this.f15216z, new e(this.A, 0));
                break;
        }
    }
}
