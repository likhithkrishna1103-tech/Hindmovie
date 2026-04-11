package h;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import java.util.WeakHashMap;
import o.x1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class h extends c0 implements DialogInterface {
    public final f B;

    public h(Context context, int i) {
        super(context, h(context, i));
        this.B = new f(getContext(), this, getWindow());
    }

    public static int h(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(g.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // h.c0, c.o, android.app.Dialog
    public void onCreate(Bundle bundle) {
        int i;
        ListAdapter listAdapter;
        View viewFindViewById;
        super.onCreate(bundle);
        f fVar = this.B;
        fVar.f5323b.setContentView(fVar.f5345z);
        Context context = fVar.f5322a;
        Window window = fVar.f5324c;
        View viewFindViewById2 = window.findViewById(g.f.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(g.f.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(g.f.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(g.f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(g.f.customPanel);
        View view = fVar.f5327g;
        if (view == null) {
            view = null;
        }
        boolean z10 = view != null;
        if (!z10 || !f.a(view)) {
            window.setFlags(131072, 131072);
        }
        if (z10) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(g.f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (fVar.f5328h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (fVar.f != null) {
                ((LinearLayout.LayoutParams) ((x1) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(g.f.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(g.f.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(g.f.buttonPanel);
        ViewGroup viewGroupB = f.b(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupB2 = f.b(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupB3 = f.b(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(g.f.scrollView);
        fVar.f5337r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        fVar.f5337r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupB2.findViewById(R.id.message);
        fVar.f5341v = textView;
        if (textView != null) {
            String str = fVar.f5326e;
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setVisibility(8);
                fVar.f5337r.removeView(fVar.f5341v);
                if (fVar.f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) fVar.f5337r.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(fVar.f5337r);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(fVar.f, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupB2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupB3.findViewById(R.id.button1);
        fVar.i = button;
        com.google.android.material.datepicker.l lVar = fVar.F;
        button.setOnClickListener(lVar);
        if (TextUtils.isEmpty(fVar.f5329j)) {
            fVar.i.setVisibility(8);
            i = 0;
        } else {
            fVar.i.setText(fVar.f5329j);
            fVar.i.setVisibility(0);
            i = 1;
        }
        Button button2 = (Button) viewGroupB3.findViewById(R.id.button2);
        fVar.f5331l = button2;
        button2.setOnClickListener(lVar);
        if (TextUtils.isEmpty(fVar.f5332m)) {
            fVar.f5331l.setVisibility(8);
        } else {
            fVar.f5331l.setText(fVar.f5332m);
            fVar.f5331l.setVisibility(0);
            i |= 2;
        }
        Button button3 = (Button) viewGroupB3.findViewById(R.id.button3);
        fVar.f5334o = button3;
        button3.setOnClickListener(lVar);
        if (TextUtils.isEmpty(fVar.f5335p)) {
            fVar.f5334o.setVisibility(8);
        } else {
            fVar.f5334o.setText(fVar.f5335p);
            fVar.f5334o.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(g.a.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                Button button4 = fVar.i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i == 2) {
                Button button5 = fVar.f5331l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i == 4) {
                Button button6 = fVar.f5334o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i == 0) {
            viewGroupB3.setVisibility(8);
        }
        if (fVar.f5342w != null) {
            viewGroupB.addView(fVar.f5342w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(g.f.title_template).setVisibility(8);
        } else {
            fVar.f5339t = (ImageView) window.findViewById(R.id.icon);
            if (TextUtils.isEmpty(fVar.f5325d) || !fVar.D) {
                window.findViewById(g.f.title_template).setVisibility(8);
                fVar.f5339t.setVisibility(8);
                viewGroupB.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(g.f.alertTitle);
                fVar.f5340u = textView2;
                textView2.setText(fVar.f5325d);
                Drawable drawable = fVar.f5338s;
                if (drawable != null) {
                    fVar.f5339t.setImageDrawable(drawable);
                } else {
                    fVar.f5340u.setPadding(fVar.f5339t.getPaddingLeft(), fVar.f5339t.getPaddingTop(), fVar.f5339t.getPaddingRight(), fVar.f5339t.getPaddingBottom());
                    fVar.f5339t.setVisibility(8);
                }
            }
        }
        boolean z11 = viewGroup.getVisibility() != 8;
        int i10 = (viewGroupB == null || viewGroupB.getVisibility() == 8) ? 0 : 1;
        boolean z12 = viewGroupB3.getVisibility() != 8;
        if (!z12 && (viewFindViewById = viewGroupB2.findViewById(g.f.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i10 != 0) {
            NestedScrollView nestedScrollView2 = fVar.f5337r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (fVar.f5326e == null && fVar.f == null) ? null : viewGroupB.findViewById(g.f.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupB2.findViewById(g.f.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = fVar.f;
        if (alertController$RecycleListView != null) {
            alertController$RecycleListView.getClass();
            if (!z12 || i10 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i10 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f516v, alertController$RecycleListView.getPaddingRight(), z12 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f517w);
            }
        }
        if (!z11) {
            View view2 = fVar.f;
            if (view2 == null) {
                view2 = fVar.f5337r;
            }
            if (view2 != null) {
                int i11 = z12 ? 2 : 0;
                View viewFindViewById11 = window.findViewById(g.f.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(g.f.scrollIndicatorDown);
                WeakHashMap weakHashMap = t0.m0.f11777a;
                t0.e0.b(view2, i10 | i11, 3);
                if (viewFindViewById11 != null) {
                    viewGroupB2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupB2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = fVar.f;
        if (alertController$RecycleListView2 == null || (listAdapter = fVar.f5343x) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i12 = fVar.f5344y;
        if (i12 > -1) {
            alertController$RecycleListView2.setItemChecked(i12, true);
            alertController$RecycleListView2.setSelection(i12);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.B.f5337r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.B.f5337r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // h.c0, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        f fVar = this.B;
        fVar.f5325d = charSequence;
        TextView textView = fVar.f5340u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
