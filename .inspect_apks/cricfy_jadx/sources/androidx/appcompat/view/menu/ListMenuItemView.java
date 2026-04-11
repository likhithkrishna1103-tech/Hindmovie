package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import g.a;
import g.f;
import g.g;
import g.j;
import n.k;
import n.m;
import n.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements x, AbsListView.SelectionBoundsAdjuster {
    public TextView A;
    public ImageView B;
    public ImageView C;
    public LinearLayout D;
    public final Drawable E;
    public final int F;
    public final Context G;
    public boolean H;
    public final Drawable I;
    public final boolean J;
    public LayoutInflater K;
    public boolean L;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public m f520v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImageView f521w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RadioButton f522x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f523y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CheckBox f524z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = a.listMenuViewStyle;
        l7.a aVarF = l7.a.F(getContext(), attributeSet, j.MenuView, i);
        this.E = aVarF.u(j.MenuView_android_itemBackground);
        int i10 = j.MenuView_android_itemTextAppearance;
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        this.F = typedArray.getResourceId(i10, -1);
        this.H = typedArray.getBoolean(j.MenuView_preserveIconSpacing, false);
        this.G = context;
        this.I = aVarF.u(j.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, a.dropDownListViewStyle, 0);
        this.J = typedArrayObtainStyledAttributes.hasValue(0);
        aVarF.G();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.K == null) {
            this.K = LayoutInflater.from(getContext());
        }
        return this.K;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    @Override // n.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(n.m r11) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.a(n.m):void");
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.C;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
        rect.top = this.C.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override // n.x
    public m getItemData() {
        return this.f520v;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.E);
        TextView textView = (TextView) findViewById(f.title);
        this.f523y = textView;
        int i = this.F;
        if (i != -1) {
            textView.setTextAppearance(this.G, i);
        }
        this.A = (TextView) findViewById(f.shortcut);
        ImageView imageView = (ImageView) findViewById(f.submenuarrow);
        this.B = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.I);
        }
        this.C = (ImageView) findViewById(f.group_divider);
        this.D = (LinearLayout) findViewById(f.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        if (this.f521w != null && this.H) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f521w.getLayoutParams();
            int i11 = layoutParams.height;
            if (i11 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i11;
            }
        }
        super.onMeasure(i, i10);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.f522x == null && this.f524z == null) {
            return;
        }
        if ((this.f520v.f8565x & 4) != 0) {
            if (this.f522x == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f522x = radioButton;
                LinearLayout linearLayout = this.D;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f522x;
            view = this.f524z;
        } else {
            if (this.f524z == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f524z = checkBox;
                LinearLayout linearLayout2 = this.D;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f524z;
            view = this.f522x;
        }
        if (z10) {
            compoundButton.setChecked(this.f520v.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f524z;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f522x;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if ((this.f520v.f8565x & 4) != 0) {
            if (this.f522x == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f522x = radioButton;
                LinearLayout linearLayout = this.D;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f522x;
        } else {
            if (this.f524z == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f524z = checkBox;
                LinearLayout linearLayout2 = this.D;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f524z;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.L = z10;
        this.H = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.C;
        if (imageView != null) {
            imageView.setVisibility((this.J || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        k kVar = this.f520v.f8555n;
        boolean z10 = this.L;
        if (z10 || this.H) {
            ImageView imageView = this.f521w;
            if (imageView == null && drawable == null && !this.H) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f521w = imageView2;
                LinearLayout linearLayout = this.D;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.H) {
                this.f521w.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f521w;
            if (!z10) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f521w.getVisibility() != 0) {
                this.f521w.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f523y.getVisibility() != 8) {
                this.f523y.setVisibility(8);
            }
        } else {
            this.f523y.setText(charSequence);
            if (this.f523y.getVisibility() != 0) {
                this.f523y.setVisibility(0);
            }
        }
    }
}
