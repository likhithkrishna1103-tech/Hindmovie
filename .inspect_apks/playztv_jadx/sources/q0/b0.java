package q0;

import android.text.TextUtils;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends f1.c {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f10420y;

    public b0(int i, Class cls, int i10, int i11, int i12) {
        this.f10420y = i12;
        this.f4691u = i;
        this.f4694x = cls;
        this.f4693w = i10;
        this.f4692v = i11;
    }

    @Override // f1.c
    public final Object c(View view) {
        switch (this.f10420y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Boolean.valueOf(j0.c(view));
            case 1:
                return j0.a(view);
            default:
                return Boolean.valueOf(j0.b(view));
        }
    }

    @Override // f1.c
    public final void d(View view, Object obj) {
        switch (this.f10420y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j0.f(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                j0.e(view, (CharSequence) obj);
                break;
            default:
                j0.d(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // f1.c
    public final boolean g(Object obj, Object obj2) {
        switch (this.f10420y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
    }
}
