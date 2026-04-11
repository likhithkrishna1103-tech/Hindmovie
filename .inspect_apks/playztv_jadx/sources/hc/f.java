package hc;

import android.graphics.Insets;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.PlayerActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6036a;

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        switch (this.f6036a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = MainActivity.F0;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = windowInsets.getInsets(WindowInsets.Type.systemBars()).top;
                view.setLayoutParams(layoutParams);
                break;
            case 1:
                int i10 = MainActivity.F0;
                Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(insets.left, insets.top, insets.right, insets.bottom);
                view.setLayoutParams(marginLayoutParams);
                break;
            case 2:
                int i11 = PlayerActivity.M0;
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.height = windowInsets.getInsets(WindowInsets.Type.systemBars()).top;
                view.setLayoutParams(layoutParams2);
                break;
            default:
                int i12 = PlayerActivity.M0;
                ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                layoutParams3.height = windowInsets.getInsets(WindowInsets.Type.systemBars()).bottom;
                view.setLayoutParams(layoutParams3);
                break;
        }
        return windowInsets;
    }
}
