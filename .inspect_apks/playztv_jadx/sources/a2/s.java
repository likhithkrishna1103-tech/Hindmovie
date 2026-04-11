package a2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.charset.Charset;
import wa.n2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements z9.f, s1.m, s1.n, z6.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f396u;

    public /* synthetic */ s(int i) {
        this.f396u = i;
    }

    @Override // s1.m
    public void a(Object obj) {
        switch (this.f396u) {
            case 1:
                ((p1.u0) obj).K(new q(2, new y0("Player release timed out."), 1003));
                break;
            case 2:
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
            case 19:
            default:
                ((b2.n) obj).getClass();
                break;
            case 3:
                ((p1.u0) obj).u();
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                ((b2.n) obj).getClass();
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                ((b2.n) obj).getClass();
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                ((b2.n) obj).getClass();
                break;
            case 8:
                ((b2.n) obj).getClass();
                break;
            case 9:
                ((b2.n) obj).getClass();
                break;
            case 10:
                ((b2.n) obj).getClass();
                break;
            case 11:
                ((b2.n) obj).getClass();
                break;
            case 12:
                ((b2.n) obj).getClass();
                break;
            case 13:
                ((b2.n) obj).getClass();
                break;
            case 14:
                ((b2.n) obj).getClass();
                break;
            case 15:
                ((b2.n) obj).getClass();
                break;
            case 16:
                ((b2.n) obj).getClass();
                break;
            case 17:
                ((b2.n) obj).getClass();
                break;
            case 18:
                ((b2.n) obj).getClass();
                break;
            case 20:
                ((b2.n) obj).getClass();
                break;
            case 21:
                ((b2.n) obj).getClass();
                break;
            case 22:
                ((b2.n) obj).getClass();
                break;
            case 23:
                ((b2.n) obj).getClass();
                break;
            case 24:
                ((b2.n) obj).getClass();
                break;
            case 25:
                ((b2.n) obj).getClass();
                break;
            case 26:
                ((b2.n) obj).getClass();
                break;
            case 27:
                ((b2.n) obj).getClass();
                break;
            case 28:
                ((b2.n) obj).getClass();
                break;
        }
    }

    @Override // z9.f
    public Object apply(Object obj) {
        switch (this.f396u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new b2.h((s1.w) obj);
            default:
                ab.a.f770b.getClass();
                return xa.a.f14333a.I((n2) obj).getBytes(Charset.forName("UTF-8"));
        }
    }

    @Override // s1.n
    public void i(Object obj, p1.o oVar) {
        switch (this.f396u) {
            case 2:
                ((p1.u0) obj).M(new p1.t0(oVar));
                break;
            default:
                break;
        }
    }

    public /* synthetic */ s(o0 o0Var) {
        this.f396u = 2;
    }
}
