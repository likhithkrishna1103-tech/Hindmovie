package b6;

import androidx.media3.decoder.DecoderInputBuffer;
import c6.i;
import i6.h;
import i6.m;
import i6.q;
import i6.r;
import java.io.File;
import ue.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1828b;

    public /* synthetic */ c(int i, Object obj) {
        this.f1827a = i;
        this.f1828b = obj;
    }

    @Override // i6.r
    public final q a(Object obj, int i, int i10, i iVar) {
        switch (this.f1827a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h hVar = (h) obj;
                return new q(hVar, new a((d) this.f1828b, hVar));
            case 1:
                byte[] bArr = (byte[]) obj;
                return new q(new w6.d(bArr), new m(bArr, 1, (i6.c) this.f1828b));
            case 2:
                return new q(new w6.d(obj), new d6.b(1, obj.toString(), (i6.c) this.f1828b));
            default:
                File file = (File) obj;
                return new q(new w6.d(file), new d6.b(2, file, (i6.c) this.f1828b));
        }
    }

    @Override // i6.r
    public final boolean b(Object obj) {
        switch (this.f1827a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return true;
            case 1:
                return true;
            case 2:
                return obj.toString().startsWith("data:image");
            default:
                return true;
        }
    }
}
