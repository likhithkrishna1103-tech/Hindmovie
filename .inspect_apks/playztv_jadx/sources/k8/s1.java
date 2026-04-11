package k8;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o1 f7421e;

    public /* synthetic */ s1(o1 o1Var, String str, String str2, String str3, int i) {
        this.f7417a = i;
        this.f7418b = str;
        this.f7419c = str2;
        this.f7420d = str3;
        this.f7421e = o1Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f7417a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x3 x3Var = this.f7421e.f7348d;
                x3Var.d0();
                i iVar = x3Var.f7546w;
                x3.y(iVar);
                return iVar.f2(this.f7418b, this.f7419c, this.f7420d);
            case 1:
                x3 x3Var2 = this.f7421e.f7348d;
                x3Var2.d0();
                i iVar2 = x3Var2.f7546w;
                x3.y(iVar2);
                return iVar2.f2(this.f7418b, this.f7419c, this.f7420d);
            case 2:
                x3 x3Var3 = this.f7421e.f7348d;
                x3Var3.d0();
                i iVar3 = x3Var3.f7546w;
                x3.y(iVar3);
                return iVar3.F1(this.f7418b, this.f7419c, this.f7420d);
            default:
                x3 x3Var4 = this.f7421e.f7348d;
                x3Var4.d0();
                i iVar4 = x3Var4.f7546w;
                x3.y(iVar4);
                return iVar4.F1(this.f7418b, this.f7419c, this.f7420d);
        }
    }
}
