package win.amos698.sweettools.mrepository.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import win.amos698.sweettools.mrepository.repo.FoodRepo;
import win.amos698.sweettools.mrepository.repo.model.Food;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodRepoApi {

    private FoodRepo foodRepo;

    @Autowired
    public FoodRepoApi(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }

    @PostMapping("/add")
    public void addFood(@RequestBody Food food) {
        foodRepo.save(food);
    }

    @DeleteMapping("/delete")
    public void deleteFood(@RequestParam Long id) {
        foodRepo.deleteById(id);
    }

    @PutMapping("/update")
    public void updateFood(@RequestBody Food food) {
        Optional<Food> foodOptional = foodRepo.findById(food.getId());
        if (foodOptional.isPresent()) {
            Food f = foodOptional.get();
            if (food.getFoodName() != null) {
                f.setFoodName(food.getFoodName());
            }
            if (food.getFoodDesc() != null) {
                f.setFoodDesc(food.getFoodDesc());
            }
            if (food.getFoodImg() != null) {
                f.setFoodImg(food.getFoodImg());
            }
            foodRepo.save(f);
        }

    }

    @GetMapping("/findById")
    public Food findFoodById(@RequestParam Long id) {
        Optional<Food> foodOptional = foodRepo.findById(id);
        return foodOptional.orElse(new Food());
    }

    @GetMapping("/findAll")
    public List<Food> findFoodById() {
        return foodRepo.findAll();
    }
}
