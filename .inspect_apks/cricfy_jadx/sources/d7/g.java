package d7;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3477b;

    public /* synthetic */ g(Context context, int i) {
        this.f3476a = i;
        this.f3477b = context;
    }

    @Override // d7.u
    public final t a(a0 a0Var) {
        switch (this.f3476a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new b(this.f3477b, this);
            case 1:
                return new b(this.f3477b, this);
            case 2:
                return new b(this.f3477b, this);
            case 3:
                return new p(this.f3477b, 0);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return new b(this.f3477b, a0Var.b(Integer.class, AssetFileDescriptor.class));
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return new b(this.f3477b, a0Var.b(Integer.class, InputStream.class));
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return new p(this.f3477b, 1);
            default:
                return new p(this.f3477b, 2);
        }
    }
}
