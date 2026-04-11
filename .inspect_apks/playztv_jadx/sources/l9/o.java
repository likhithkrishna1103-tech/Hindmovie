package l9;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import j9.t;
import java.util.ArrayList;
import m.b0;
import n.k2;
import n.n0;
import n.q0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8060u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f8061v;

    public /* synthetic */ o(int i, Object obj) {
        this.f8060u = i;
        this.f8061v = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Activity activity;
        Rect rect;
        int i = this.f8060u;
        int i10 = 0;
        Object obj = this.f8061v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                NavigationView navigationView = (NavigationView) obj;
                int[] iArr = navigationView.F;
                navigationView.getLocationOnScreen(iArr);
                boolean z2 = iArr[1] == 0;
                t tVar = navigationView.C;
                if (tVar.R != z2) {
                    tVar.R = z2;
                    int i11 = (tVar.f6902v.getChildCount() <= 0 && tVar.R) ? tVar.T : 0;
                    NavigationMenuView navigationMenuView = tVar.f6901u;
                    navigationMenuView.setPadding(0, i11, 0, navigationMenuView.getPaddingBottom());
                }
                navigationView.setDrawTopInsetForeground(z2 && navigationView.I);
                int i12 = iArr[0];
                navigationView.setDrawLeftInsetForeground(i12 == 0 || navigationView.getWidth() + i12 == 0);
                Context context = navigationView.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        activity = null;
                    } else if (context instanceof Activity) {
                        activity = (Activity) context;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (activity != null) {
                    int i13 = Build.VERSION.SDK_INT;
                    WindowManager windowManager = (WindowManager) activity.getSystemService("window");
                    if (i13 >= 30) {
                        rect = windowManager.getCurrentWindowMetrics().getBounds();
                    } else {
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        Point point = new Point();
                        defaultDisplay.getRealSize(point);
                        rect = new Rect();
                        rect.right = point.x;
                        rect.bottom = point.y;
                    }
                    navigationView.setDrawBottomInsetForeground((rect.height() - navigationView.getHeight() == iArr[1]) == true && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) == true && navigationView.J);
                    navigationView.setDrawRightInsetForeground(rect.width() == iArr[0] || rect.width() - navigationView.getWidth() == iArr[0]);
                }
                break;
            case 1:
                m.e eVar = (m.e) obj;
                ArrayList arrayList = eVar.B;
                if (eVar.a() && arrayList.size() > 0 && !((m.d) arrayList.get(0)).f8182a.S) {
                    View view = eVar.I;
                    if (view != null && view.isShown()) {
                        int size = arrayList.size();
                        while (i10 < size) {
                            Object obj2 = arrayList.get(i10);
                            i10++;
                            ((m.d) obj2).f8182a.d();
                        }
                    } else {
                        eVar.dismiss();
                    }
                    break;
                }
                break;
            case 2:
                b0 b0Var = (b0) obj;
                k2 k2Var = b0Var.B;
                if (b0Var.a() && !k2Var.S) {
                    View view2 = b0Var.G;
                    if (view2 != null && view2.isShown()) {
                        k2Var.d();
                    } else {
                        b0Var.dismiss();
                    }
                    break;
                }
                break;
            case 3:
                q0 q0Var = (q0) obj;
                if (!q0Var.getInternalPopup().a()) {
                    q0Var.f8506z.l(q0Var.getTextDirection(), q0Var.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = q0Var.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
                break;
            default:
                n0 n0Var = (n0) obj;
                q0 q0Var2 = n0Var.f8457b0;
                n0Var.getClass();
                if (q0Var2.isAttachedToWindow() && q0Var2.getGlobalVisibleRect(n0Var.Z)) {
                    n0Var.r();
                    n0Var.d();
                } else {
                    n0Var.dismiss();
                }
                break;
        }
    }
}
