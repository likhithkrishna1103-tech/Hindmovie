package g7;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements x6.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f5181b;

    public /* synthetic */ f(p pVar, int i) {
        this.f5180a = i;
        this.f5181b = pVar;
    }

    @Override // x6.j
    public final boolean a(Object obj, x6.h hVar) {
        switch (this.f5180a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5181b.getClass();
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                String str = Build.MANUFACTURER;
                return (!("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912) && !"robolectric".equals(Build.FINGERPRINT);
        }
    }

    @Override // x6.j
    public final z6.b0 b(Object obj, int i, int i10, x6.h hVar) {
        switch (this.f5180a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p pVar = this.f5181b;
                return pVar.a(new androidx.emoji2.text.v((ByteBuffer) obj, pVar.f5211d, pVar.f5210c, 16), i, i10, hVar, p.f5206k);
            default:
                p pVar2 = this.f5181b;
                return pVar2.a(new androidx.emoji2.text.v((ParcelFileDescriptor) obj, pVar2.f5211d, pVar2.f5210c), i, i10, hVar, p.f5206k);
        }
    }
}
