package bf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends xe.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2080e;
    public final /* synthetic */ p f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f2082h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(String str, p pVar, int i, int i10, int i11) {
        super(str, true);
        this.f2080e = i11;
        this.f = pVar;
        this.f2081g = i;
        this.f2082h = i10;
    }

    @Override // xe.a
    public final long a() {
        switch (this.f2080e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p pVar = this.f;
                try {
                    pVar.Q.G(this.f2081g, this.f2082h, true);
                    return -1L;
                } catch (IOException e10) {
                    pVar.a(2, 2, e10);
                    return -1L;
                }
            case 1:
                a0 a0Var = this.f.E;
                int i = this.f2082h;
                a0Var.getClass();
                l4.a.u("errorCode", i);
                synchronized (this.f) {
                    this.f.S.remove(Integer.valueOf(this.f2081g));
                }
                return -1L;
            default:
                p pVar2 = this.f;
                try {
                    int i10 = this.f2081g;
                    int i11 = this.f2082h;
                    l4.a.u("statusCode", i11);
                    pVar2.Q.H(i10, i11);
                    return -1L;
                } catch (IOException e11) {
                    pVar2.a(2, 2, e11);
                    return -1L;
                }
        }
    }
}
