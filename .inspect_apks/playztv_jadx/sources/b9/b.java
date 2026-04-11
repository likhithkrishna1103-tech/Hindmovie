package b9;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.chip.Chip;
import de.hdodenhof.circleimageview.CircleImageView;
import q9.w;
import q9.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1946b;

    public /* synthetic */ b(int i, Object obj) {
        this.f1945a = i;
        this.f1946b = obj;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f1945a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = ((Chip) this.f1946b).f3378y;
                if (eVar == null) {
                    outline.setAlpha(0.0f);
                } else {
                    eVar.getOutline(outline);
                }
                break;
            case 1:
                CircleImageView circleImageView = (CircleImageView) this.f1946b;
                if (!circleImageView.N) {
                    Rect rect = new Rect();
                    circleImageView.f4191v.roundOut(rect);
                    outline.setRoundRect(rect, rect.width() / 2.0f);
                } else {
                    ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                }
                break;
            case 2:
                w wVar = (w) this.f1946b;
                if (wVar.f11159c != null && !wVar.f11160d.isEmpty()) {
                    RectF rectF = wVar.f11160d;
                    outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, wVar.f11162g);
                    break;
                }
                break;
            default:
                Path path = ((x) this.f1946b).f11161e;
                if (!path.isEmpty()) {
                    outline.setPath(path);
                }
                break;
        }
    }
}
