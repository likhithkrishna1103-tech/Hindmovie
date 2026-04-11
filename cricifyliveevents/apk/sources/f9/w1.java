package f9;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a2 f4460e;

    public /* synthetic */ w1(a2 a2Var, String str, String str2, String str3, int i) {
        this.f4456a = i;
        this.f4457b = str;
        this.f4458c = str2;
        this.f4459d = str3;
        this.f4460e = a2Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4456a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a2 a2Var = this.f4460e;
                a2Var.f4001d.w();
                n nVar = a2Var.f4001d.f4355x;
                q4.P(nVar);
                return nVar.i2(this.f4457b, this.f4458c, this.f4459d);
            case 1:
                a2 a2Var2 = this.f4460e;
                a2Var2.f4001d.w();
                n nVar2 = a2Var2.f4001d.f4355x;
                q4.P(nVar2);
                return nVar2.i2(this.f4457b, this.f4458c, this.f4459d);
            case 2:
                a2 a2Var3 = this.f4460e;
                a2Var3.f4001d.w();
                n nVar3 = a2Var3.f4001d.f4355x;
                q4.P(nVar3);
                return nVar3.m2(this.f4457b, this.f4458c, this.f4459d);
            default:
                a2 a2Var4 = this.f4460e;
                a2Var4.f4001d.w();
                n nVar4 = a2Var4.f4001d.f4355x;
                q4.P(nVar4);
                return nVar4.m2(this.f4457b, this.f4458c, this.f4459d);
        }
    }
}
