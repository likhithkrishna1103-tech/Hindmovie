package ka;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.chip.Chip;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7390b;

    public /* synthetic */ y(int i, Object obj) {
        this.f7389a = i;
        this.f7390b = obj;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f7389a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z zVar = (z) this.f7390b;
                if (zVar.f7386c != null && !zVar.f7387d.isEmpty()) {
                    RectF rectF = zVar.f7387d;
                    outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, zVar.f7391g);
                    break;
                }
                break;
            case 1:
                Path path = ((a0) this.f7390b).f7388e;
                if (!path.isEmpty()) {
                    outline.setPath(path);
                }
                break;
            case 2:
                CircleImageView circleImageView = (CircleImageView) this.f7390b;
                if (!circleImageView.O) {
                    Rect rect = new Rect();
                    circleImageView.f3689w.roundOut(rect);
                    outline.setRoundRect(rect, rect.width() / 2.0f);
                } else {
                    ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                }
                break;
            default:
                v9.c cVar = ((Chip) this.f7390b).f2837z;
                if (cVar == null) {
                    outline.setAlpha(0.0f);
                } else {
                    cVar.getOutline(outline);
                }
                break;
        }
    }
}
