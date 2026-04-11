package t0;

import android.text.TextUtils;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends l1.c {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f11830z;

    public z(int i, Class cls, int i10, int i11, int i12) {
        this.f11830z = i12;
        this.f7624v = i;
        this.f7627y = cls;
        this.f7626x = i10;
        this.f7625w = i11;
    }

    @Override // l1.c
    public final Object c(View view) {
        switch (this.f11830z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Boolean.valueOf(h0.c(view));
            case 1:
                return h0.a(view);
            case 2:
                return j0.b(view);
            default:
                return Boolean.valueOf(h0.b(view));
        }
    }

    @Override // l1.c
    public final void d(View view, Object obj) {
        switch (this.f11830z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h0.f(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                h0.e(view, (CharSequence) obj);
                break;
            case 2:
                j0.c(view, (CharSequence) obj);
                break;
            default:
                h0.d(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // l1.c
    public final boolean g(Object obj, Object obj2) {
        boolean zEquals;
        switch (this.f11830z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            case 2:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
        return !zEquals;
    }
}
