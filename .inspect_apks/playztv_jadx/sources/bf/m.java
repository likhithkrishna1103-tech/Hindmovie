package bf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends xe.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2088e = 1;
    public final /* synthetic */ p f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2089g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, p pVar, int i, List list) {
        super(str, true);
        this.f = pVar;
        this.f2089g = i;
    }

    private final long b() {
        this.f.E.getClass();
        try {
            this.f.Q.H(this.f2089g, 9);
            synchronized (this.f) {
                this.f.S.remove(Integer.valueOf(this.f2089g));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }

    @Override // xe.a
    public final long a() {
        switch (this.f2088e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return b();
            default:
                this.f.E.getClass();
                try {
                    this.f.Q.H(this.f2089g, 9);
                    synchronized (this.f) {
                        this.f.S.remove(Integer.valueOf(this.f2089g));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, p pVar, int i, List list, boolean z2) {
        super(str, true);
        this.f = pVar;
        this.f2089g = i;
    }
}
