package d7;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f3463b = new d0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3464a;

    public /* synthetic */ d0(int i) {
        this.f3464a = i;
    }

    @Override // d7.u
    public final t a(a0 a0Var) {
        switch (this.f3464a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return e0.f3467b;
            case 1:
                return new d(0, new c(0));
            case 2:
                return new d(0, new c(1));
            case 3:
                return new e0(1);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return new c0(a0Var.b(Uri.class, AssetFileDescriptor.class), 0);
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return new c0(a0Var.b(Uri.class, ParcelFileDescriptor.class), 0);
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return new c0(a0Var.b(Uri.class, InputStream.class), 0);
            default:
                return new h0(a0Var.b(j.class, InputStream.class));
        }
    }
}
