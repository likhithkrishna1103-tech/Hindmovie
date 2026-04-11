package r5;

import android.graphics.Insets;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.PlayerActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10858a;

    public /* synthetic */ d(int i) {
        this.f10858a = i;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        switch (this.f10858a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = MainActivity.B0;
                Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(insets.left, insets.top, insets.right, insets.bottom);
                view.setLayoutParams(marginLayoutParams);
                break;
            case 1:
                int i10 = PlayerActivity.I0;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = windowInsets.getInsets(WindowInsets.Type.systemBars()).top;
                view.setLayoutParams(layoutParams);
                break;
            default:
                int i11 = PlayerActivity.I0;
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.height = windowInsets.getInsets(WindowInsets.Type.systemBars()).bottom;
                view.setLayoutParams(layoutParams2);
                break;
        }
        return windowInsets;
    }
}
