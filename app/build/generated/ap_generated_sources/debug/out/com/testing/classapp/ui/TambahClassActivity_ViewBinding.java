// Generated code from Butter Knife. Do not modify!
package com.testing.classapp.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.testing.classapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TambahClassActivity_ViewBinding implements Unbinder {
  private TambahClassActivity target;

  private View view7f08004a;

  @UiThread
  public TambahClassActivity_ViewBinding(TambahClassActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TambahClassActivity_ViewBinding(final TambahClassActivity target, View source) {
    this.target = target;

    View view;
    target.edtNamaKelas = Utils.findRequiredViewAsType(source, R.id.edtNamaKelas, "field 'edtNamaKelas'", EditText.class);
    target.edtNamaWali = Utils.findRequiredViewAsType(source, R.id.edtNamaWali, "field 'edtNamaWali'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnSimpan, "field 'btnSimpan' and method 'onViewClicked'");
    target.btnSimpan = Utils.castView(view, R.id.btnSimpan, "field 'btnSimpan'", Button.class);
    view7f08004a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TambahClassActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtNamaKelas = null;
    target.edtNamaWali = null;
    target.btnSimpan = null;

    view7f08004a.setOnClickListener(null);
    view7f08004a = null;
  }
}
