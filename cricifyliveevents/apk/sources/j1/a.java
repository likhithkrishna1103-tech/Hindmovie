package j1;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        DrawerLayout drawerLayout = (DrawerLayout) view;
        boolean z10 = false;
        boolean z11 = windowInsets.getSystemWindowInsetTop() > 0;
        drawerLayout.S = windowInsets;
        drawerLayout.T = z11;
        if (!z11 && drawerLayout.getBackground() == null) {
            z10 = true;
        }
        drawerLayout.setWillNotDraw(z10);
        drawerLayout.requestLayout();
        return windowInsets.consumeSystemWindowInsets();
    }
}
