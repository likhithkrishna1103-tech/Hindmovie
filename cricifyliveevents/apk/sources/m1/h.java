package m1;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends androidx.emoji2.text.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8032a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f8033b;

    public h(EditText editText) {
        this.f8033b = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.j
    public void a() {
        switch (this.f8032a) {
            case 1:
                SwitchCompat switchCompat = (SwitchCompat) this.f8033b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                }
                break;
        }
    }

    @Override // androidx.emoji2.text.j
    public final void b() {
        switch (this.f8032a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i.a((EditText) this.f8033b.get(), 1);
                break;
            default:
                SwitchCompat switchCompat = (SwitchCompat) this.f8033b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                }
                break;
        }
    }

    public h(SwitchCompat switchCompat) {
        this.f8033b = new WeakReference(switchCompat);
    }
}
