package v9;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f13352e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(m mVar, int i) {
        super(mVar);
        this.f13352e = i;
    }

    @Override // v9.n
    public void q() {
        switch (this.f13352e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m mVar = this.f13377b;
                mVar.I = null;
                CheckableImageButton checkableImageButton = mVar.A;
                checkableImageButton.setOnLongClickListener(null);
                i5.a.M(checkableImageButton, null);
                break;
        }
    }
}
