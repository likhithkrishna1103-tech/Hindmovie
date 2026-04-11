package l6;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements c6.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f7973b;

    public /* synthetic */ f(o oVar, int i) {
        this.f7972a = i;
        this.f7973b = oVar;
    }

    @Override // c6.k
    public final boolean a(Object obj, c6.i iVar) {
        switch (this.f7972a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f7973b.getClass();
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                String str = Build.MANUFACTURER;
                return (!("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912) && !"robolectric".equals(Build.FINGERPRINT);
        }
    }

    @Override // c6.k
    public final e6.b0 b(Object obj, int i, int i10, c6.i iVar) {
        switch (this.f7972a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                o oVar = this.f7973b;
                return oVar.a(new kc.b((ByteBuffer) obj, oVar.f7995d, oVar.f7994c, 3), i, i10, iVar, o.f7990k);
            default:
                o oVar2 = this.f7973b;
                return oVar2.a(new kc.b((ParcelFileDescriptor) obj, oVar2.f7995d, oVar2.f7994c), i, i10, iVar, o.f7990k);
        }
    }
}
